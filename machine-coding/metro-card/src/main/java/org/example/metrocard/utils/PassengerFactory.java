package org.example.metrocard.utils;

import org.example.metrocard.models.users.Adult;
import org.example.metrocard.models.users.Kid;
import org.example.metrocard.models.users.Passenger;
import org.example.metrocard.models.users.SeniorCitizen;

public class PassengerFactory {

  public Passenger getPassenger(String type, String name) {
    if (type == null) {
      return null;
    }
    switch (type) {
      case "ADULT": {
        return new Adult(name);
      }
      case "KID": {
        return new Kid(name);
      }
      default: {
        return new SeniorCitizen(name);
      }
    }
  }

}
