package org.shashtra.strategies;

import java.math.BigDecimal;

public interface ParkingChargeStrategy {
  default BigDecimal getParkingCharges() {
    throw new UnsupportedOperationException("Strategy not implemented");
  }
}
