package main.java.org.example.metrocard.models.stations;

import main.java.org.example.metrocard.constants.MetroConstants;

public class CentralStation extends MetroStation {

  @Override
  public String getStationName() {
    return MetroConstants.CENTRAL_STATION;
  }
}
