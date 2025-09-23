package org.shashtra.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BikeParkingStrategy implements ParkingChargeStrategy {

  private static BikeParkingStrategy instance = null;

  private BikeParkingStrategy() {}

  public static BikeParkingStrategy getInstance() {
    if (instance == null) {
      // can make it synchronized, but let's keep it synchronized free for now
      instance = new BikeParkingStrategy();
    }
    return instance;
  }

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN);
  }
}
