package org.shashtra.factories;

import jakarta.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.shashtra.models.VehicleType;
import org.shashtra.strategies.ParkingChargeStrategy;

@Singleton
public class ParkingStrategyFactory {

  private final Map<VehicleType, ParkingChargeStrategy> strategyMap;

  public ParkingStrategyFactory(List<ParkingChargeStrategy> strategies) {
    strategyMap =
        strategies.stream()
            .collect(Collectors.toMap(ParkingChargeStrategy::getSlotType, Function.identity()));
  }

  public ParkingChargeStrategy getParkingStrategy(VehicleType type) {
    ParkingChargeStrategy strategy = strategyMap.get(type);
    if (strategy == null) {
      throw new UnsupportedOperationException("Strategy not implemented for: " + type.name());
    }
    return strategy;
  }
}
