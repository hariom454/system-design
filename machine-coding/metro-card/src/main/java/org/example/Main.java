package org.example;

import org.example.service.CardService;

public class Main {

  public static void main(String[] args) {
    System.out.println("Starting the card service, specify operation as asked");
    CardService cardService = new CardService();
    cardService.getInput();
  }
}