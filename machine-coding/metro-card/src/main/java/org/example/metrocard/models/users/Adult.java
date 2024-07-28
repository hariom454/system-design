package org.example.metrocard.models.users;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.users.Passenger;

public class Adult extends Passenger {

  public Adult(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.ADULT;
  }

}
