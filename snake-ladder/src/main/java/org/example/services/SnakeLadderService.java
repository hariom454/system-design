package org.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.example.models.Ladder;
import org.example.models.Player;
import org.example.models.Snake;
import org.example.utils.Utils;

public class SnakeLadderService {

  private static SnakeLadderService instance;
  private Map<Integer, Snake> snakeMap = new HashMap<>();
  private Map<Integer, Ladder> ladderMap = new HashMap<>();
  private List<Player> players = new ArrayList<>();


  private SnakeLadderService() {
  }

  public static SnakeLadderService getInstance() {
    if (instance == null) {
      instance = new SnakeLadderService();
    }
    return instance;
  }

  public void getInput() {
    Scanner sc = new Scanner(System.in);
    //System.out.println("Enter number of snakes: ");
    int n = sc.nextInt();
    //System.out.println("Enter head and tail of snakes: ");
    for (int i = 0; i < n; i++) {
      int head = sc.nextInt();
      int tail = sc.nextInt();
      snakeMap.put(head, new Snake(head, tail));
    }
    //System.out.println("Enter number of ladders: ");
    int m = sc.nextInt();
    //System.out.println("Enter ladder start and end position: ");
    for (int i = 0; i < m; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      ladderMap.put(start, new Ladder(start, end));
    }
    //System.out.println("Enter number of players: ");
    int p = sc.nextInt();
    //System.out.println("Enter player names: ");
    sc.nextLine(); //skipp new line
    for (int i = 0; i < p; i++) {
      String player = sc.nextLine();
      players.add(new Player(player, 0));
    }
    sc.close();
  }

  public void play() {
    players.forEach(System.out::println);
    //start
    int sz = players.size();
    int turn = 0;
    while (true) {
      //
      int diceNum = Utils.rollDice();
      Player player = players.get(turn);
      turn = (turn + 1) % sz;
      //Gaurav rolled a 6 and moved from 0 to 6

      int finalPosition = player.getPosition() + diceNum;

      finalPosition = finalPosition > 100 ? player.getPosition() : getFinalPosition(finalPosition);
      System.out.println(
          player.getName() + " rolled a " + diceNum + " and move from " + player.getPosition()
              + " to " + finalPosition);

      if (finalPosition == 100) {
        System.out.println(player.getName() + " wins the game");
        break;
      }
      player.setPosition(finalPosition);
    }

  }

  private int getFinalPosition(int position) {
    if (snakeMap.containsKey(position)) {
      Snake snake = snakeMap.get(position);
      return getFinalPosition(snake.getTail());
    }
    if (ladderMap.containsKey(position)) {
      Ladder ladder = ladderMap.get(position);
      return getFinalPosition(ladder.getEnd());
    }
    return position;
  }

}
