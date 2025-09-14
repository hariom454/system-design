package main.java.org.example.metrocard.models.users;

import main.java.org.example.metrocard.constants.MetroConstants;
import main.java.org.example.metrocard.models.users.Passenger;

public class Adult extends Passenger {

  public Adult(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.ADULT;
  }

}
