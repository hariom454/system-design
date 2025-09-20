package org.shashtra.services;

import java.util.List;
import java.util.Optional;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;

public class ParkingService {
  private ParkingLot parkingLot;
  private TicketService ticketService;

  public Ticket parkVehicle(Vehicle vehicle) throws NotFoundException {
    Slot slot = findEmptySlot(vehicle);
    slot.occupySlot(vehicle.id());

    return ticketService.createTicket(vehicle, slot);
  }

  public Ticket unparkVehicle(String ticketId) throws NotFoundException {

    Ticket ticket = ticketService.ticketWithCharges(ticketId);
    ticket.getSlot().freeSlot();
    ticket.setVehicleId(null);

    return ticket;
  }

  private Slot findEmptySlot(Vehicle vehicle) throws NotFoundException {
    List<Floor> floors = parkingLot.floors();
    for (Floor floor : floors) {
      List<Slot> slots = floor.slots();
      Optional<Slot> res =
          slots.stream()
              .filter(slot -> slot.isAvailable() && slot.getSlotType() == vehicle.vehicleType())
              .findFirst();
      if (res.isPresent()) {
        return res.get();
      }
    }
    throw new NotFoundException("No free slot available for: " + vehicle.vehicleType());
  }

  public void displayFreeSlots() {
    List<Floor> floors = parkingLot.floors();
    System.out.println("==========Free Slots at parking: " + parkingLot.id() + " ===========");
    floors.forEach(
        floor -> {
          System.out.println("Available slots at floor: " + floor.id());
          List<Slot> freeSlots = floor.slots().stream().filter(Slot::isAvailable).toList();
          freeSlots.forEach(
              slot -> {
                System.out.println("SlotId: " + slot.getId() + " " + slot.getSlotType());
              });
        });
  }
}
