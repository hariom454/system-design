package org.shashtra.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BikeParkingStrategy implements ParkingChargeStrategy {

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN);
  }
}
