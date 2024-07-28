package org.example.metrocard.constants;

import java.util.HashMap;
import java.util.Map;

public class MetroConstants {

  public static final String ADULT = "ADULT";
  public static final String SENIOR_CITIZEN = "SENIOR_CITIZEN";
  public static final String KIDS = "KIDS";

  public static final Map<String, Integer> tc = new HashMap<>();

  static {
    tc.put(ADULT, 200);
    tc.put(SENIOR_CITIZEN, 100);
    tc.put(KIDS, 50);
  }

}
