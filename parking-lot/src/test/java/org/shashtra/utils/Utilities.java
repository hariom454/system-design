package org.shashtra.utils;

import java.util.ArrayList;
import java.util.UUID;
import org.shashtra.models.Floor;
import org.shashtra.models.ParkingLot;
import org.shashtra.models.Slot;
import org.shashtra.models.Vehicle;
import org.shashtra.models.VehicleType;

public class Utilities {
  public static ParkingLot createParkingLotWithoutFloors(int id) {
    return new ParkingLot(id, new ArrayList<>());
  }

  public static Vehicle createVehicle(VehicleType type) {
    return new Vehicle(type.name() + "-" + UUID.randomUUID().toString(), type);
  }

  public static Floor createFloor(int id) {
    Floor floor = new Floor(id);
    floor.addSlot(createSlot("1"));
    return floor;
  }

  public static Slot createSlot(String id) {
    return new Slot(id, VehicleType.BIKE);
  }
}
