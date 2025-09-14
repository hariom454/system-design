package main.java.org.example.metrocard.models.users;

public abstract class Passenger {

  private final String name;

  public Passenger(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String getUserType();

}
