package main.java.org.example.metrocard.models.stations;

import main.java.org.example.metrocard.constants.MetroConstants;

public class AirportMetroStation extends MetroStation {

  @Override
  public String getStationName() {
    return MetroConstants.AIRPORT_STATION;
  }
}
