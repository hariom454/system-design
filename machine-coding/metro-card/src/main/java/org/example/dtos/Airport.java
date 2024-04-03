package org.example.dtos;

import java.util.HashMap;

public class Airport {

  String name;

  public HashMap<PassengerType, Integer> getCount() {
    return count;
  }

  public void setCount(HashMap<PassengerType, Integer> count) {
    this.count = count;
  }

  HashMap<PassengerType, Integer> count;
  int totalPassenger;

  public Airport(String name) {
    this.name = name;
    this.totalPassenger = 0;
    this.count = new HashMap<>();

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTotalPassenger() {
    return totalPassenger;
  }

  public void setTotalPassenger(int totalPassenger) {
    this.totalPassenger = totalPassenger;
  }

  public Double getFees() {
    return fees;
  }

  public void setFees(Double fees) {
    this.fees = fees;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  Double fees = 0.0;
  Double totalAmount = 0.0;
  Double amount = 0.0;
  Double discount = 0.0;



}
