package org.shashtra.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;
import org.shashtra.repository.TicketRepository;
import org.shashtra.strategies.BikeParkingStrategy;
import org.shashtra.strategies.BusParkingStrategy;
import org.shashtra.strategies.ParkingChargeStrategy;
import org.shashtra.strategies.SUVParkingStrategy;

public class TicketService {

  private final TicketRepository ticketRepository;

  public TicketService(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public Ticket createTicket(Vehicle vehicle, Slot slot) {
    Ticket ticket =
        new Ticket(
            UUID.randomUUID().toString(),
            vehicle.id(),
            slot.getId(),
            slot.getSlotType(),
            System.currentTimeMillis());
    ticketRepository.addTicket(ticket);
    return ticket;
  }

  public Ticket ticketWithCharges(String ticketId) throws NotFoundException {

    Ticket ticket = ticketRepository.getTicket(ticketId);

    long now = System.currentTimeMillis();
    ticket.setUnparkedAt(now);
    ticket.setCharges(calculateParkingCharges(ticket));
    return ticket;
  }

  private BigDecimal calculateParkingCharges(Ticket ticket) {
    long diff = ticket.getUnparkedAt() - ticket.getParkedAt();

    // scale the duration by 1000 to see the diff when duration is converted in hours
    double duration = 1000 * diff * 1.0 / (1000 * 60 * 60);

    ParkingChargeStrategy strategy = getParkingStrategy(ticket.getVehicleType());
    ticket.setCharges(
        strategy
            .getParkingCharges()
            .multiply(BigDecimal.valueOf(duration))
            .setScale(2, RoundingMode.HALF_DOWN));
    return ticket.getCharges();
  }

  private ParkingChargeStrategy getParkingStrategy(VehicleType type) {
    switch (type) {
      case VehicleType.BUS -> {
        return new BusParkingStrategy();
      }
      case VehicleType.SUV -> {
        return new SUVParkingStrategy();
      }
      case VehicleType.BIKE -> {
        return new BikeParkingStrategy();
      }
      default -> {
        throw new IllegalArgumentException(
            "Not supported type, implement the parking strategy and add here");
      }
    }
  }
}
