package org.example.metrocard.models;

public abstract class Passenger {

  private final String name;

  public Passenger(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  abstract String getUserType();

}
