package main.java.org.example.metrocard.utils;

public class Pair {

  private final String key;
  private final int value;

  public Pair(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }
}
