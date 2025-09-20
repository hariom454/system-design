package org.shashtra.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Slot;
import org.shashtra.models.Ticket;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;

public class TicketService {

  private Map<String, Ticket> tickets;

  public TicketService() {
    this.tickets = new HashMap<>();
  }

  public Ticket createTicket(Vehicle vehicle, Slot slot) {
    Ticket ticket =
        new Ticket(UUID.randomUUID().toString(), vehicle.id(), slot, System.currentTimeMillis());
    tickets.put(ticket.getId(), ticket);
    return ticket;
  }

  public Ticket ticketWithCharges(String ticketId) throws NotFoundException {
    if (!tickets.containsKey(ticketId)) {
      throw new NotFoundException("Invalid ticket id: " + ticketId);
    }
    Ticket ticket = tickets.get(ticketId);

    long now = System.currentTimeMillis();
    ticket.setUnparkedAt(now);
    ticket.setCharges(getParkingCharges(ticket));
    return ticket;
  }

  private BigDecimal getParkingCharges(Ticket ticket) {
    VehicleType type = ticket.getSlot().getSlotType();
    long diff = ticket.getUnparkedAt() - ticket.getParkedAt();
    Duration duration = Duration.ofMillis(diff);

    ticket.setCharges(charges(type).multiply(BigDecimal.valueOf(duration.toHours())));
    return ticket.getCharges();
  }

  private BigDecimal charges(VehicleType type) {
    switch (type) {
      case VehicleType.BUS -> {
        return BigDecimal.valueOf(50);
      }
      case VehicleType.SUV -> {
        return BigDecimal.valueOf(20);
      }
      default -> {
        return BigDecimal.valueOf(30);
      }
    }
  }
}
