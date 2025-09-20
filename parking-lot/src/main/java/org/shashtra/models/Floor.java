package org.shashtra.models;

import java.util.List;

public record Floor(int id, List<Slot> slots) {
  public void addSlot(Slot slot) {
    this.slots.add(slot);
  }
}
