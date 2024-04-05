package org.example;

import org.example.service.CardService;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    CardService cardService = new CardService();
    cardService.getInput();
  }
}