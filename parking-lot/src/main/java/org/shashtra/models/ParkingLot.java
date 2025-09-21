package org.shashtra.models;

import java.util.List;

public record ParkingLot(int id, List<Floor> floors) {
  public void addFloor(Floor floor) {
    this.floors.add(floor);
  }

  public void displayFreeSlots() {
    System.out.println("========== Available Free Slots ===========");
    floors.forEach(
        floor -> {
          System.out.println("Available slots at floor: " + floor.getId());
          List<Slot> freeSlots = floor.getSlots().stream().filter(Slot::isAvailable).toList();
          freeSlots.forEach(
              slot -> {
                System.out.println(slot.getSlotType() + " " + slot.getId());
              });
        });

    System.out.println("======================================");
  }

  public void getParkedVehicles() {
    System.out.println("========== Occupied Free Slots ===========");
    floors.forEach(
        floor -> {
          System.out.println("Occupied slots at floor: " + floor.getId());
          List<Slot> freeSlots =
              floor.getSlots().stream().filter(slot -> !slot.isAvailable()).toList();
          freeSlots.forEach(
              slot -> {
                System.out.println(slot.getSlotType() + " " + slot.getId());
              });
        });

    System.out.println("======================================");
  }
}
