package org.shashtra.repository;

import java.util.HashMap;
import java.util.Map;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Ticket;

public class TicketRepository {
  private final Map<String, Ticket> tickets;

  public TicketRepository() {
    tickets = new HashMap<>();
  }

  public void addTicket(Ticket ticket) {
    tickets.put(ticket.getId(), ticket);
  }

  public Ticket getTicket(String ticketId) throws NotFoundException {
    if (!tickets.containsKey(ticketId)) {
      throw new NotFoundException("Ticket not found with id: " + ticketId);
    }

    return tickets.get(ticketId);
  }
}
