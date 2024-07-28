package org.example.metrocard.models.users;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.users.Passenger;

public class Kid extends Passenger {

  public Kid(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.KID;
  }

}
