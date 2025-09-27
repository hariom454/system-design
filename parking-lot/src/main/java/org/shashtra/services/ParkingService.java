package org.shashtra.services;

import jakarta.inject.Singleton;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;

@Singleton
public final class ParkingService {
  private final ParkingLot parkingLot;
  private final TicketService ticketService;

  public ParkingService(ParkingLot parkingLot, TicketService ticketService) {
    this.parkingLot = parkingLot;
    this.ticketService = ticketService;
  }

  public Ticket parkVehicle(Vehicle vehicle) throws NotFoundException {
    Slot slot = findEmptySlot(vehicle);
    slot.occupySlot(vehicle.id());

    return ticketService.createTicket(vehicle, slot);
  }

  public Ticket unparkVehicle(String ticketId) throws NotFoundException {

    Ticket ticket = ticketService.ticketWithCharges(ticketId);

    Slot slot =
        parkingLot.floors().stream()
            .map(Floor::getSlots)
            .flatMap(
                slots -> slots.stream().filter(slot1 -> slot1.getId().equals(ticket.getSlotId())))
            .findFirst()
            .orElseThrow(
                () -> new RuntimeException("Slot id not valid! check the application logic"));

    slot.freeSlot();
    slot.setVehicleId(null);
    return ticket;
  }

  private Slot findEmptySlot(Vehicle vehicle) throws NotFoundException {
    List<Floor> floors = parkingLot.floors();
    for (Floor floor : floors) {
      List<Slot> slots = floor.getSlots();
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

  public ParkingLot parkingLot() {
    return parkingLot;
  }

  public TicketService ticketService() {
    return ticketService;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (ParkingService) obj;
    return Objects.equals(this.parkingLot, that.parkingLot)
        && Objects.equals(this.ticketService, that.ticketService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parkingLot, ticketService);
  }

  @Override
  public String toString() {
    return "ParkingService["
        + "parkingLot="
        + parkingLot
        + ", "
        + "ticketService="
        + ticketService
        + ']';
  }
}
