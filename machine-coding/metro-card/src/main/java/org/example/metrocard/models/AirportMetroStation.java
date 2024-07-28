package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;

public class AirportMetroStation extends MetroStation {

  @Override
  public String getStationName() {
    return MetroConstants.AIRPORT_STATION;
  }
}
