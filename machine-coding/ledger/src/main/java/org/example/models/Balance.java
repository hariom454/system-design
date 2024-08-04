package org.example.models;

public class Balance {

  private String bankName;
  private String userName;
  private int repaymentAmount;
  private int remainingEmi;

  public Balance(int repaymentAmount, int remainingEmi) {
    this.repaymentAmount = repaymentAmount;
    this.remainingEmi = remainingEmi;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getRepaymentAmount() {
    return repaymentAmount;
  }

  public int getRemainingEmi() {
    return remainingEmi;
  }

}
