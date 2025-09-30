package org.shashtra.strategies;

import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.shashtra.models.VehicleType;

@Singleton
public class BusParkingStrategy implements ParkingChargeStrategy {

  private final VehicleType slotType = VehicleType.BUS;

  @Override
  public BigDecimal getParkingCharges() {
    return new BigDecimal(50).setScale(2, RoundingMode.HALF_EVEN);
  }

  @Override
  public VehicleType getSlotType() {
    return this.slotType;
  }

  @Override
  public boolean supports(VehicleType type) {
    return this.slotType == type;
  }
}
