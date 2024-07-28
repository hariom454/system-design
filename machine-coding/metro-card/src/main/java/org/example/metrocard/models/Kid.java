package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.Passenger;

public class Kid extends Passenger {

  public Kid(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.KID;
  }

}
