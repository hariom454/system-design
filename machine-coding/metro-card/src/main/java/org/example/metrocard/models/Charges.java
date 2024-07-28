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
    if (discount >= 0) {
      this.discount = discount;
    } else {
      throw new IllegalArgumentException("discount shouldn't be negative.");
    }
  }

  public int getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(int serviceFee) {
    if (serviceFee >= 0) {
      this.serviceFee = serviceFee;
    } else {
      throw new IllegalArgumentException("service fees shouldn't be negative.");

    }
  }
}
