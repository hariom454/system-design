package org.example.metrocard.utils;

import org.example.metrocard.models.stations.AirportMetroStation;
import org.example.metrocard.models.stations.CentralStation;
import org.example.metrocard.models.stations.MetroStation;

public class MetroStationFactory {

  AirportMetroStation airport = new AirportMetroStation();
  CentralStation central = new CentralStation();

  public MetroStation getMetroStation(String station) {
    if (station.equalsIgnoreCase("AIRPORT")) {
      return airport;
    }
    return central;
  }

}
