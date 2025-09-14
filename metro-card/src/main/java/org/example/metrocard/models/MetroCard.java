package main.java.org.example.metrocard.models;

public class MetroCard {

  private final String number;
  private int balance;

  public MetroCard(String id, int balance) {
    this.number = id;
    this.balance = balance;
  }

  public String getNumber() {
    return number;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int amount) {
    this.balance = Math.max(this.balance + amount, 0);
  }

  public int getServiceFee(int fare) {
    if (this.balance < fare) {
      int dif = fare - this.balance;
      dif *= 0.02;
      return dif;
    }
    return 0;
  }
}
