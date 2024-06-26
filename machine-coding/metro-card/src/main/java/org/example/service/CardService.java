package org.example.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import org.example.dtos.Airport;
import org.example.dtos.CommandType;
import org.example.dtos.Passenger;
import org.example.dtos.PassengerType;

public class CardService {

  HashMap<String, Double> balances = new HashMap<>();
  HashMap<String, Airport> airports = new HashMap<>();
  HashMap<String, Passenger> passengers = new HashMap<>();

  public void getInput() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      if (Objects.equals(line, "exit")) {
        break;
      }
      String[] items = line.split(" ");
      processInput(items);
    }
    sc.close();
  }

  public void getInput(String filepath) {
    try {
      Scanner sc = new Scanner(new BufferedReader(new FileReader(filepath)));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] items = line.split(" ");
        processInput(items);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void processInput(String[] items) {
    CommandType commandType = CommandType.valueOf(items[0]);
    switch (commandType) {
      case BALANCE: {
        String cardNumber = items[1];
        Double amount = Double.valueOf(items[2]);
        balances.put(cardNumber, amount);
        break;
      }
      case CHECK_IN: {
        // card number passenger type airport
        String cardNumber = items[1];
        PassengerType passengerType = PassengerType.valueOf(items[2]);
        String airportName = items[3];
        checkIn(cardNumber, airportName, passengerType);
        break;
      }
      case PRINT_SUMMARY: {
        printSummary();
        break;
      }
    }
  }

  void checkIn(String cardNumber, String airportName, PassengerType passengerType) {

    Airport airport;
    if (airports.containsKey(airportName)) {
      airport = airports.get(airportName);
    } else {
      airport = new Airport(airportName);
      airports.put(airportName, airport);
    }
    double charges = getCharge(passengerType);
    Passenger passenger;
    if (passengers.containsKey(cardNumber)) {
      passenger = passengers.get(cardNumber);
      if (passenger.getFromStation() != null && !Objects.equals(passenger.getFromStation(),
          airportName)) {
        charges /= 2;
        airport.setDiscount(airport.getDiscount() + charges);
        passenger.setFromStation(null);
      }
    } else {
      passenger = new Passenger(cardNumber);
      passenger.setPassengerType(passengerType);
      passenger.setFromStation(airportName);
      passengers.put(cardNumber, passenger);
    }
    Double availableAmount = balances.get(cardNumber);
    if (availableAmount < charges) {
      double rechargeAmount = charges - availableAmount;
      double fees = 0.02 * rechargeAmount;
      airport.setFees(airport.getFees() + fees);
      charges += fees;
    }
    balances.put(cardNumber, Math.max(availableAmount - charges, 0));
    airport.setTotalAmount(airport.getTotalAmount() + charges);
    int count =
        airport.getCount().get(passengerType) != null ? airport.getCount().get(passengerType) + 1
            : 1;
    airport.getCount().put(passengerType, count);
    airport.setTotalPassenger(airport.getTotalPassenger() + 1);
  }

  private int getCharge(PassengerType passengerType) {
    switch (passengerType) {
      case ADULT: {
        return 200;
      }
      case KID: {
        return 50;
      }
      case SENIOR_CITIZEN: {
        return 100;
      }
    }
    return 0;
  }

  private void printSummary() {
    printAirportSummary("CENTRAL");
    printAirportSummary("AIRPORT");
  }

  private void printAirportSummary(String airport) {

    Airport value = airports.get(airport);

    System.out.println("TOTAL_COLLECTION " + airport + " " + value.getTotalAmount().intValue() + " "
        + value.getDiscount().intValue());
    HashMap<PassengerType, Integer> unsortedMap = value.getCount();
    List<SimpleEntry<Integer, String>> pas = new ArrayList<>();
    unsortedMap.forEach((key1, value1) -> pas.add(new SimpleEntry<>(value1, key1.name())));
    System.out.println("PASSENGER_TYPE_SUMMARY");
    pas.sort((first, second) -> {
      if (Objects.equals(first.getKey(), second.getKey())) {
        return first.getValue().compareTo(second.getValue());
      }
      return second.getKey() - first.getKey();
    });
    pas.forEach(item -> System.out.println(item.getValue() + " " + item.getKey()));
  }

}
