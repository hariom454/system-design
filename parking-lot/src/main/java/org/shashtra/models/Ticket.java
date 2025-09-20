package org.shashtra.models;

import java.math.BigDecimal;

public class Ticket {
  private String id;
  private String vehicleId;
  private Slot slot;
  private long parkedAt;
  private long unparkedAt;
  private BigDecimal charges;

  public Ticket(String id, String vehicleId, Slot slot, long parkedAt) {
    this.id = id;
    this.vehicleId = vehicleId;
    this.slot = slot;
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

  public Slot getSlot() {
    return slot;
  }

  public void setSlot(Slot slot) {
    this.slot = slot;
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
}
