package org.shashtra.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SUVParkingStrategy implements ParkingChargeStrategy {

  private static SUVParkingStrategy instance = null;

  private SUVParkingStrategy() {}

  public static SUVParkingStrategy getInstance() {
    if (instance == null) {
      instance = new SUVParkingStrategy();
    }

    return instance;
  }

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(25).setScale(2, RoundingMode.HALF_EVEN);
  }
}
