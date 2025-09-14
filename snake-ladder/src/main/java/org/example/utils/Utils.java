package org.example.utils;

import java.util.UUID;

public class Utils {

  public static int rollDice() {
    return (int) (Math.random() * 6 + 1);
  }

  public static String getUniqueId() {
    return UUID.randomUUID().toString();
  }

}
