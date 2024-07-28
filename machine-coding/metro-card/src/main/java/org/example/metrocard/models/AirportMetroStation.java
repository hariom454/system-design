package org.example.metrocard.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.utils.Pair;

public class AirportMetroStation implements MetroStation {

  private int total;
  private int serviceFee;
  private int discount;
  private final List<Journey> journeys;

  public AirportMetroStation() {
    this.journeys = new ArrayList<>();
  }

  @Override
  public int getTotalCollection() {
    return this.total + this.serviceFee;
  }

  @Override
  public int getTotalDiscount() {
    return this.discount;
  }

  private void updateTotalCollection(int total) {
    this.total += total;
  }

  private void updateDiscount(int amount) {
    this.discount += amount;
  }

  private void updateServiceCharges(int amount) {
    this.serviceFee += amount;
  }

  @Override
  public List<Pair> getPassengerSummary() {
    Map<String, Integer> mp = new HashMap<>();
    for (Journey j : journeys) {
      Passenger p = j.getPassenger();
      String type = p.getUserType();
      int cnt = mp.getOrDefault(type, 0) + 1;
      mp.put(type, cnt);
    }
    List<Pair> pas = new ArrayList<>();
    mp.forEach((key1, value1) -> pas.add(new Pair(key1, value1)));
    pas.sort((first, second) -> {
      if (first.getValue() == second.getValue()) {
        return first.getKey().compareTo(second.getKey());
      }
      return second.getValue() - first.getValue();
    });
    return pas;
  }

  @Override
  public void checkin(Journey j) {
    journeys.add(j);
    updateCharges(j);
  }

  @Override
  public String getStationName() {
    return MetroConstants.AIRPORT_STATION;
  }

  private void updateCharges(Journey j) {
    Charges c = j.getCharges();
    updateTotalCollection(c.getFare());
    updateDiscount(c.getDiscount());
    updateServiceCharges(c.getServiceFee());
  }

}
