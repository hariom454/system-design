package org.example.metrocard.models;

import java.util.List;
import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.utils.Pair;

public class CentralStation implements MetroStation {

  private int totalCollection;

  @Override
  public int getTotalCollection() {
    return 0;
  }

  @Override
  public int getTotalDiscount() {
    return 0;
  }

  @Override
  public List<Pair> getPassengerSummary() {
    return null;
  }

  @Override
  public void checkin(Journey j) {

  }

  @Override
  public String getStationName() {
    return MetroConstants.CENTRAL_STATION;
  }

  @Override
  public void checkin(Passenger p, Journey j, int fare) {

  }
}
