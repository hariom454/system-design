package org.shashtra.models;

import java.util.Arrays;
import java.util.Optional;

public enum VehicleType {
  SEDAN("Sedan"),
  BIKE("Bike"),
  SUV("SUV"),
  JEEP("Jeep"),
  BUS("Bus"),
  MINI_VAN("Minivan"),
  CROSS_ROVER("Crossover");

  private final String vehicleType;

  VehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleType from(String vehicleType) {
    Optional<VehicleType> res =
        Arrays.stream(VehicleType.values())
            .filter(vehicle -> vehicle.vehicleType.equals(vehicleType))
            .findFirst();

    return res.orElseThrow(() -> new IllegalArgumentException("Not Valid vehicle type"));
  }
}
