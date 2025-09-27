package org.shashtra.factories;

import jakarta.inject.Singleton;
import org.shashtra.models.VehicleType;
import org.shashtra.strategies.BikeParkingStrategy;
import org.shashtra.strategies.BusParkingStrategy;
import org.shashtra.strategies.ParkingChargeStrategy;
import org.shashtra.strategies.SUVParkingStrategy;

@Singleton
public class ParkingStrategyFactory {

  public ParkingChargeStrategy getParkingStrategy(VehicleType type) {
    return switch (type) {
      case SEDAN, JEEP -> null;
      case VehicleType.BIKE -> BikeParkingStrategy.getInstance();
      case SUV -> SUVParkingStrategy.getInstance();
      case BUS -> BusParkingStrategy.getInstance();
      default ->
          throw new UnsupportedOperationException("Strategy not implemented for: " + type.name());
    };
  }
}
