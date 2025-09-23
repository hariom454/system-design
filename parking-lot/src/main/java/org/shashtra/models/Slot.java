package org.shashtra.models;

public class Slot {
  private final String id;
  private final VehicleType slotType;
  private boolean isAvailable;
  private String vehicleId;

  public Slot(String id, VehicleType slotType) {
    this.id = id;
    this.slotType = slotType;
    this.isAvailable = true;
  }

  public void occupySlot(String vehicleId) {
    this.vehicleId = vehicleId;
    this.isAvailable = false;
  }

  public void freeSlot() {
    this.isAvailable = true;
  }

  public String getId() {
    return id;
  }

  public VehicleType getSlotType() {
    return slotType;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  @Override
  public String toString() {
    return "Slot{"
        + "id='"
        + id
        + '\''
        + ", slotType="
        + slotType
        + ", isAvailable="
        + isAvailable
        + ", vehicleId='"
        + vehicleId
        + '\''
        + '}';
  }
}
