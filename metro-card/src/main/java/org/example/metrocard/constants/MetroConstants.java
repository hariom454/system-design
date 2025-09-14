package main.java.org.example.metrocard.constants;

import java.util.HashMap;
import java.util.Map;

public class MetroConstants {

  public static final String ADULT = "ADULT";
  public static final String SENIOR_CITIZEN = "SENIOR_CITIZEN";
  public static final String KID = "KID";

  public static final String AIRPORT_STATION = "AIRPORT";
  public static final String CENTRAL_STATION = "CENTRAL";

  public static final Map<String, Integer> tc = new HashMap<>();

  static {
    tc.put(ADULT, 200);
    tc.put(SENIOR_CITIZEN, 100);
    tc.put(KID, 50);
  }

}
