package org.example;

import org.example.services.SnakeLadderService;

public class Main {

  public static void main(String[] args) {
    SnakeLadderService snakeLadderService = SnakeLadderService.getInstance();
    snakeLadderService.getInput();
    snakeLadderService.play();
  }
}