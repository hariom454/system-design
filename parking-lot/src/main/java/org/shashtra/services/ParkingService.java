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

  public ParkingService(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
    this.ticketService = new TicketService();
  }

  public Ticket parkVehicle(Vehicle vehicle) throws NotFoundException {
    Slot slot = findEmptySlot(vehicle);
    slot.occupySlot(vehicle.id());

    return ticketService.createTicket(vehicle, slot);
  }

  public Ticket unparkVehicle(String ticketId) throws NotFoundException {

    Ticket ticket = ticketService.ticketWithCharges(ticketId);

    // get slot and make it free
    String[] ids = ticket.getSlotId().split("-");
    Slot slot =
        parkingLot.floors().get(Integer.parseInt(ids[1])).slots().get(Integer.parseInt(ids[2]));
    slot.freeSlot();
    slot.setVehicleId(null);
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
}
