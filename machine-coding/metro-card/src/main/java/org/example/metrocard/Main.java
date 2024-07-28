package org.example.metrocard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.example.metrocard.services.MetroService;

public class Main {

  private static final MetroService metroService = new MetroService();

  private static void getInput(String filepath) {
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

  public static void processInput(String[] input) {
    String command = input[0];
    switch (command) {
      case "BALANCE": {
        String number = input[1];
        int amount = Integer.parseInt(input[2]);
        metroService.addMetroCard(number, amount);
        break;
      }
      case "CHECK_IN": {
        String number = input[1];
        String type = input[2];
        String from = input[3];
        metroService.checkIn(number, type, from);
        break;
      }
      default: {
        metroService.printSummary();
        break;
      }
    }
  }

  public static void main(String[] args) {
    getInput(args[0]);
  }

}
