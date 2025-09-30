package org.shashtra.strategies;

import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.shashtra.models.VehicleType;

@Singleton
public class BikeParkingStrategy implements ParkingChargeStrategy {

  private final VehicleType slotType = VehicleType.BIKE;

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN);
  }

  @Override
  public VehicleType getSlotType() {
    return this.slotType;
  }

  @Override
  public boolean supports(VehicleType type) {
    return slotType == type;
  }
}
