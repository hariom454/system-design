package org.shashtra.models;

import io.micronaut.serde.annotation.Serdeable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.shashtra.dto.TicketDto;

@Serdeable
public class Ticket {
  private final String id;
  private final Vehicle vehicle;
  private final String slotId;
  private final long parkedAt;
  private long unparkedAt;
  private BigDecimal charges;

  public Ticket(String id, Vehicle vehicle, String slotId, long parkedAt) {
    this.id = id;
    this.vehicle = vehicle;
    this.slotId = slotId;
    this.parkedAt = parkedAt;
  }

  public String getId() {
    return id;
  }

  public long getParkedAt() {
    return parkedAt;
  }

  public long getUnparkedAt() {
    return unparkedAt;
  }

  public void setUnparkedAt(long unparkedAt) {
    this.unparkedAt = unparkedAt;
  }

  public BigDecimal getCharges() {
    return charges;
  }

  public void setCharges(BigDecimal charges) {
    this.charges = charges;
  }

  public String getSlotId() {
    return slotId;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public TicketDto ticketDto() {
    return new TicketDto(
        this.id,
        this.vehicle,
        this.slotId,
        getLocalTime(this.parkedAt),
        getLocalTime(this.unparkedAt),
        this.charges);
  }

  private String getLocalTime(long time) {
    if (time == 0) {
      return null;
    }

    Instant instant = Instant.ofEpochMilli(time);
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toString();
  }

  @Override
  public String toString() {
    return "Ticket{"
        + "id='"
        + id
        + '\''
        + ", vehicle="
        + vehicle
        + ", slotId='"
        + slotId
        + '\''
        + ", parkedAt="
        + parkedAt
        + ", unparkedAt="
        + unparkedAt
        + ", charges="
        + charges
        + '}';
  }
}
