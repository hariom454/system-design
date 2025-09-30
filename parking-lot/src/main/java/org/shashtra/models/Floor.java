package org.shashtra.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
  private final int id;
  private final int parkingLotId;
  private final List<Slot> slots;

  public Floor(int id, int parkingLotId) {
    this.id = id;
    this.parkingLotId = parkingLotId;
    slots = new ArrayList<>();
  }

  public void addSlot(Slot slot) {
    this.slots.add(slot);
  }

  public int getId() {
    return id;
  }

  public List<Slot> getSlots() {
    return slots;
  }

  public int getParkingLotId() {
    return parkingLotId;
  }
}
