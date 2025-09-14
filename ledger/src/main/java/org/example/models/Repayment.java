package org.example.models;

public class Repayment {

  private int amount;
  private int emiNumber;

  public Repayment(int amount, int number) {
    this.amount = amount;
    this.emiNumber = number;
  }

  public int getAmount() {
    return amount;
  }

  public int getEmiNumber() {
    return emiNumber;
  }
}
