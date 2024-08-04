package org.example.models;

public class Balance {

  private int repaymentAmount;
  private int remainingEmi;

  public Balance(int repaymentAmount, int remainingEmi) {
    this.repaymentAmount = repaymentAmount;
    this.remainingEmi = remainingEmi;
  }

  public int getRepaymentAmount() {
    return repaymentAmount;
  }

  public int getRemainingEmi() {
    return remainingEmi;
  }

}
