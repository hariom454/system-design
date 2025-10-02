package org.shashtra.services;

import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.factories.ParkingStrategyFactory;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.repository.TicketRepository;
import org.shashtra.strategies.ParkingChargeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TicketService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TicketService.class);

  private final TicketRepository ticketRepository;
  private final ParkingStrategyFactory parkingStrategyFactory;

  public TicketService(
      TicketRepository ticketRepository, ParkingStrategyFactory parkingStrategyFactory) {
    this.ticketRepository = ticketRepository;
    this.parkingStrategyFactory = parkingStrategyFactory;
  }

  public Ticket createTicket(Vehicle vehicle, Slot slot) {
    Ticket ticket =
        new Ticket(UUID.randomUUID().toString(), vehicle, slot.getId(), System.currentTimeMillis());
    ticketRepository.addTicket(ticket);
    LOGGER.info("Ticket created: {} for vehicle: {}", ticket.getId(), vehicle.id());
    return ticket;
  }

  public Ticket ticketWithCharges(String ticketId) throws NotFoundException {

    Ticket ticket = ticketRepository.getTicket(ticketId);
    if (ticket.getUnparkedAt() != 0) {
      LOGGER.error("Vehicle already unparked, vehicle id: {}", ticket.getVehicle().id());
      throw new IllegalStateException(
          "Vehicle already unparked, vehicle id: " + ticket.getVehicle().id());
    }

    long now = System.currentTimeMillis();
    ticket.setUnparkedAt(now);
    ticket.setCharges(calculateParkingCharges(ticket));
    return ticket;
  }

  private BigDecimal calculateParkingCharges(Ticket ticket) {
    long diff = ticket.getUnparkedAt() - ticket.getParkedAt();

    // scale the duration by 1000 to see the diff when duration is converted in hours
    double duration = 1000 * diff * 1.0 / (1000 * 60 * 60);

    ParkingChargeStrategy strategy =
        parkingStrategyFactory.getParkingStrategy(ticket.getVehicle().vehicleType());
    ticket.setCharges(
        strategy
            .getParkingCharges()
            .multiply(BigDecimal.valueOf(duration))
            .setScale(2, RoundingMode.HALF_DOWN));
    return ticket.getCharges();
  }
}
