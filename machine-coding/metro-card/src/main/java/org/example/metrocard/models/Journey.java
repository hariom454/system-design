package org.example.metrocard.models;

public class Journey {

  private String from;
  private String to;
  private final Passenger passenger;

  public Journey(String from, String to, Passenger passenger) {
    this.from = from;
    this.to = to;
    this.passenger = passenger;
  }

  public boolean isReturnJourney(String to) {
    return from != null && !from.equalsIgnoreCase(to);
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Passenger getPassenger() {
    return passenger;
  }
}
