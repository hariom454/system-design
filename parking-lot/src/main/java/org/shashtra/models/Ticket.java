package org.shashtra.models;

import java.math.BigDecimal;

public class Ticket {
  private final String id;
  private final String vehicleId;
  private final VehicleType vehicleType;
  private final String slotId;
  private final long parkedAt;
  private long unparkedAt;
  private BigDecimal charges;

  public Ticket(
      String id, String vehicleId, String slotId, VehicleType vehicleType, long parkedAt) {
    this.id = id;
    this.vehicleId = vehicleId;
    this.slotId = slotId;
    this.vehicleType = vehicleType;
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

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public String getSlotId() {
    return slotId;
  }

  @Override
  public String toString() {
    return "Ticket{"
        + "id='"
        + id
        + '\''
        + ", vehicleId='"
        + vehicleId
        + '\''
        + ", slotId='"
        + slotId
        + '\''
        + ", vehicleType='"
        + vehicleType
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
