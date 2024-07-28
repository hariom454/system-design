package org.example.metrocard.models;

import org.example.metrocard.constants.MetroConstants;
import org.example.metrocard.models.Passenger;

public class SeniorCitizen implements Passenger {

  private final String name;

  public SeniorCitizen(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getUserType() {
    return MetroConstants.SENIOR_CITIZEN;
  }

}
