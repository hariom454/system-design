package main.java.org.example.metrocard.models.users;

import main.java.org.example.metrocard.constants.MetroConstants;
import main.java.org.example.metrocard.models.users.Passenger;

public class Kid extends Passenger {

  public Kid(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.KID;
  }

}
