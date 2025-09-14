package main.java.org.example.metrocard.models.users;

import main.java.org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.users.Passenger;

public class SeniorCitizen extends Passenger {

  public SeniorCitizen(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.SENIOR_CITIZEN;
  }

}
