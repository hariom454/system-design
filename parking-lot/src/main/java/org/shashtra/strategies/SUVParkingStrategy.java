package org.shashtra.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SUVParkingStrategy implements ParkingChargeStrategy {

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(25).setScale(2, RoundingMode.HALF_EVEN);
  }
}
