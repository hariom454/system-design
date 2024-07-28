package org.example.metrocard.models;

import java.util.List;
import org.example.metrocard.utils.Pair;

public class AirportMetroStation implements MetroStation {

  private int totalCollection;
  private int transactionFees;
  private int discount;
  private List<Journey> journeys;

  @Override
  public int getTotalCollection() {
    return totalCollection;
  }

  @Override
  public List<Pair> getPassengerSummary() {
    return null;
  }

  public void checkin(Passenger passenger, MetroCard metroCard){

  }
}
