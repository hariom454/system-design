package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.Passenger;

public class Kid implements Passenger {

  private final String name;

  public Kid(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getUserType() {
    return MetroConstants.KID;
  }

}
