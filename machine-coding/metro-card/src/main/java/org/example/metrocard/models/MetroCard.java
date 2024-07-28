package org.example.metrocard.models;

public class MetroCard {

  private final String number;
  private int balance;
  private Passenger person;

  public MetroCard(String id, int balance) {
    this.number = id;
    this.balance = balance;
  }

  public String getNumber() {
    return number;
  }

  public Passenger getUser() {
    return person;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int amount) {
    this.balance += amount;
  }

  public void addUser(Passenger user) {
    this.person = user;
  }

  public int getServiceFee(int fare) {
    if (this.balance < fare) {
      int dif = fare - this.balance;
      dif *= 0.2;
      return dif;
    }
    return 0;
  }
}
