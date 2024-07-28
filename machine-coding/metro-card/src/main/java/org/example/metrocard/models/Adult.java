package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;

public class Adult extends Passenger {

  public Adult(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.ADULT;
  }

}
