package main.java.org.example.metrocard.utils;

import java.util.UUID;

public class Util {

  public static String getUniqueId() {
    return UUID.randomUUID().toString();
  }

}
