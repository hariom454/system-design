package org.example.metrocard.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.AirportMetroStation;
import org.example.metrocard.models.CentralStation;
import org.example.metrocard.models.Charges;
import org.example.metrocard.models.Journey;
import org.example.metrocard.models.MetroCard;
import org.example.metrocard.models.MetroStation;
import org.example.metrocard.models.Passenger;
import org.example.metrocard.utils.Pair;
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
    Journey journey = getLastJourney(number);

    Charges charges = getFare(journey, station, type);
    Journey newJourney = new Journey(station, passenger);
    newJourney.setCharges(charges);

    int serviceFee = metroCard.getServiceFee(charges.getFare());
    charges.setServiceFee(serviceFee);

    MetroStation metroStation = metroStations.get(station);
    metroStation.checkin(newJourney);

    List<Journey> pass = passengerJourneys.getOrDefault(number, new ArrayList<>());
    pass.add(newJourney);
    passengerJourneys.put(number, pass);
  }

  private Journey getLastJourney(String number) {
    List<Journey> pj = passengerJourneys.get(number);
    return pj != null ? pj.get(pj.size() - 1) : null;
  }

  public void printSummary() {
    printSummary(metroStations.get(MetroConstants.CENTRAL_STATION));
    printSummary(metroStations.get(MetroConstants.AIRPORT_STATION));
  }

  private void printSummary(MetroStation station) {
    System.out.println(
        "TOTAL_COLLECTION " + station.getStationName() + " " + station.getTotalCollection() + " "
            + station.getTotalDiscount());
    System.out.println("PASSENGER_TYPE_SUMMARY");
    List<Pair> pas = station.getPassengerSummary();
    pas.forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));
  }

  private boolean isReturnJourney(Journey journey, String from) {
    return journey != null && !journey.getFrom().equalsIgnoreCase(from);
  }

  private Charges getFare(Journey journey, String from, String type) {
    int fare = MetroConstants.tc.get(type);
    Charges charges = new Charges(fare);
    if (isReturnJourney(journey, from)) {
      fare /= 2;
      charges.setDiscount(fare);
    }
    return charges;
  }

}
