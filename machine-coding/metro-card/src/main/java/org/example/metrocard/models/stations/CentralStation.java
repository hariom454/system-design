package org.example.metrocard.models.stations;

import org.example.metrocard.constants.MetroConstants;

public class CentralStation extends MetroStation {

  @Override
  public String getStationName() {
    return MetroConstants.CENTRAL_STATION;
  }
}
