package org.example.metrocard.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.AirportMetroStation;
import org.example.metrocard.models.CentralStation;
import org.example.metrocard.models.Journey;
import org.example.metrocard.models.MetroCard;
import org.example.metrocard.models.MetroStation;
import org.example.metrocard.models.Passenger;
import org.example.metrocard.utils.PassengerFactory;

public class MetroService {

  private final Map<String, MetroCard> metroCards;
  private final Map<String, Passenger> passengers;
  private final PassengerFactory passengerFactory;
  private final Map<String, List<Journey>> passengerJourneys;
  private final Map<String, MetroStation> metroStations;

  public MetroService() {
    this.metroCards = new HashMap<>();
    this.passengers = new HashMap<>();
    this.passengerFactory = new PassengerFactory();
    this.passengerJourneys = new HashMap<>();
    this.metroStations = new HashMap<>();
    metroStations.put("AIRPORT", new AirportMetroStation());
    metroStations.put("CENTRAL", new CentralStation());
  }

  public void addMetroCard(String number, int amount) {
    MetroCard metroCard = new MetroCard(number, amount);
    metroCards.put(number, metroCard);
  }

  public MetroCard getMetroCard(String number) {
    return metroCards.get(number);
  }

  public Passenger addPassenger(String name, String type) {
    Passenger passenger = getPassenger(name);
    if (passenger == null) {
      passenger = passengerFactory.getPassenger(type, name);
      passengers.put(name, passenger);
    }
    return passenger;

  }

  public Passenger getPassenger(String name) {
    return passengers.get(name);
  }

  public void checkIn(String number, String type, String station) {
    Passenger passenger =
        getPassenger(number) != null ? getPassenger(number) : addPassenger(number, type);
    MetroCard metroCard = getMetroCard(number);
    Journey journey = getJourney(number);
    if (journey == null) {
      journey = new Journey(station, passenger);
    }
    int charges = MetroConstants.tc.get(type);

    if (journey.isReturnJourney(station)) {
      charges /= 2;
      passengerJourneys.remove(number);
    } else {
      passengerJourneys.putIf(number, journey);
    }

    MetroStation metroStation = metroStations.get(station);
    metroStation.


  }

  private Journey getJourney(String number) {
    return passengerJourneys.get(number);
  }

  public void printSummary() {

  }

}
