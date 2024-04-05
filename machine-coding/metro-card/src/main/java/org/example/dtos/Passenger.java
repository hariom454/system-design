package org.example.dtos;

public class Passenger {

  String cardNumber;
  PassengerType passengerType;
  String fromStation;

  public Passenger(String cardNumber) {
    this.cardNumber = cardNumber;
    this.fromStation = null;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public PassengerType getPassengerType() {
    return passengerType;
  }

  public void setPassengerType(PassengerType passengerType) {
    this.passengerType = passengerType;
  }

  public String getFromStation() {
    return fromStation;
  }

  public void setFromStation(String fromStation) {
    this.fromStation = fromStation;
  }
}
