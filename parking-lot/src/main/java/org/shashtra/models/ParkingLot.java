package org.shashtra.models;

import io.micronaut.core.annotation.Creator;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public record ParkingLot(int id, List<Floor> floors) {
  public void addFloor(Floor floor) {
    this.floors.add(floor);
  }

  // TODO: remove this type of injection and managed parking lot from different interface. inject
  // using creator with default values
  @Creator
  static ParkingLot getDefault() {
    Floor floor = new Floor(1);
    floor.addSlot(new Slot("1", VehicleType.SUV));
    return new ParkingLot(1, List.of(floor));
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
