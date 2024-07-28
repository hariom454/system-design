package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.Passenger;

public class SeniorCitizen extends Passenger {

  public SeniorCitizen(String name) {
    super(name);
  }

  @Override
  public String getUserType() {
    return MetroConstants.SENIOR_CITIZEN;
  }

}
