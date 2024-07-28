package org.example.metrocard.models;

import org.example.metrocard.utils.Util;

public class Journey {

  private final String id;
  private final String from;
  private final Passenger passenger;
  private Charges charges;


  public Journey(String from, Passenger passenger) {
    this.id = Util.getUniqueId();
    this.from = from;
    this.passenger = passenger;
  }

  public String getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }


  public Passenger getPassenger() {
    return passenger;
  }

  public Charges getCharges() {
    return charges;
  }

  public void setCharges(Charges charges) {
    this.charges = charges;
  }
}
