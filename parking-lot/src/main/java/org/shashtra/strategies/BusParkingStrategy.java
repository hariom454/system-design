package org.shashtra.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusParkingStrategy implements ParkingChargeStrategy {

  private static BusParkingStrategy instance = null;

  private BusParkingStrategy() {}

  public static BusParkingStrategy getInstance() {
    if (instance == null) {
      instance = new BusParkingStrategy();
    }
    return instance;
  }

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(50).setScale(2, RoundingMode.HALF_EVEN);
  }
}
