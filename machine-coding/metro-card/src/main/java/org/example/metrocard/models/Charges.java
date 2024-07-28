package org.example.metrocard.models;

public class Charges {

  private final int actualFare;
  private int discount;
  private int serviceFee;

  public Charges(int fare) {
    this.actualFare = fare;
    this.discount = 0;
    this.serviceFee = 0;
  }

  public int getFare() {
    return actualFare - discount;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public int getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(int serviceFee) {
    this.serviceFee = serviceFee;
  }
}
