package org.example.utils;

import java.time.Instant;
import java.util.UUID;

public class Utils {

  public static String getUniqueId() {
    return UUID.randomUUID().toString();
  }

  public static String getTimeStamp() {
    return Instant.now().toString();
  }

}
