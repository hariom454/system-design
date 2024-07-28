package org.example.metrocard.models;

public class MetroCard {

  private final String number;
  private double balance;
  private Passenger person;

  public MetroCard(String id, double balance) {
    this.number = id;
    this.balance = balance;
  }

  public String getNumber() {
    return number;
  }

  public Passenger getUser() {
    return person;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double amount) {
    this.balance += amount;
  }

  public void addUser(Passenger user) {
    this.person = user;
  }
}
