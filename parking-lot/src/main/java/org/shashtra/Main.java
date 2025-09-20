package org.shashtra;

import java.util.ArrayList;
import java.util.List;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.VehicleType;

public class Main {
  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot(1, new ArrayList<>());
    for (int i = 0; i < 3; i++) {
      Floor floor = createFloor(i);
      parkingLot.addFloor(floor);
    }
    parkingLot.displayFreeSlots();
  }

  private static Floor createFloor(int id) {
    Floor floor = new Floor(id, new ArrayList<>());

    // add 5 slots for bike
    for (int i = 0; i < 5; i++) {
      Slot slot = new Slot(VehicleType.BIKE.name() + id + "-" + i, VehicleType.BIKE);
      floor.addSlot(slot);
    }

    // add 5 slots for SUV
    for (int i = 0; i < 5; i++) {
      Slot slot = new Slot(VehicleType.SUV.name() + id + "-" + i, VehicleType.SUV);
      floor.addSlot(slot);
    }

    // add 2 slots for bus
    for (int i = 0; i < 2; i++) {
      Slot slot = new Slot(VehicleType.BUS.name() + id + "-" + i, VehicleType.BUS);
      floor.addSlot(slot);
    }

    return floor;
  }
}
