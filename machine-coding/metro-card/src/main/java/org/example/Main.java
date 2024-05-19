package org.example;

import org.example.service.CardService;

public class Main {

  public static void main(String[] args) {
    System.out.println("args: " +  args[0]);
    CardService cardService = new CardService();
    if (args.length > 0) {
      cardService.getInput(args[0]);
    } else {
      cardService.getInput();
    }
  }
}