package org.shashtra.repository;

import java.util.HashMap;
import java.util.Map;
import org.shashtra.exceptions.NotFoundException;
import org.shashtra.models.Vehicle;

public class VehicleRepository {
  private Map<String, Vehicle> vehicles;

  public VehicleRepository() {
    vehicles = new HashMap<>();
  }

  private void addVehicle(Vehicle v) {
    vehicles.put(v.id(), v);
  }

  private Vehicle getVehicle(String id) throws NotFoundException {
    if (!vehicles.containsKey(id)) {
      throw new NotFoundException("Vehicle not found: " + id);
    }

    return vehicles.get(id);
  }
}
