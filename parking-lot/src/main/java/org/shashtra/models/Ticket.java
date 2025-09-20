package org.shashtra.models;

import java.math.BigDecimal;

public class Ticket {
  private String id;
  private String vehicleId;
  private String slotId;
  private VehicleType vehicleType;
  private long parkedAt;
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

  public void setId(String id) {
    this.id = id;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public long getParkedAt() {
    return parkedAt;
  }

  public void setParkedAt(long parkedAt) {
    this.parkedAt = parkedAt;
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

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getSlotId() {
    return slotId;
  }

  public void setSlotId(String slotId) {
    this.slotId = slotId;
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
