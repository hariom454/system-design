package org.shashtra.strategies;

import java.math.BigDecimal;
import org.shashtra.models.VehicleType;

public interface ParkingChargeStrategy {
  default BigDecimal getParkingCharges() {
    throw new UnsupportedOperationException("Strategy not implemented");
  }

  VehicleType getSlotType();

  boolean supports(VehicleType type);
}
