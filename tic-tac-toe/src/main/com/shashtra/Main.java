package com.shashtra;

import java.util.Scanner;

/***************
 **  author: Hariom Singh
 **  Date: 20/03/22
 *****************/
public class Main {
    final char[] moves = {'X', 'O'};
    Player[] players;
    Board board;
    int currentPlayerId = 0;
    int totalMoves = 0;

    public Main(Player[] players) {
        this.players = players;
        board = new Board(3);
        totalMoves = 3 * 3;
        board.showBoard();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input players name
        Player[] players = new Player[2];
        String first = in.nextLine();
        String second = in.nextLine();
        players[0] = new Player(first);
        players[1] = new Player(second);

        Main driver = new Main(players);
        int x, y;
        while (driver.totalMoves > 0) {
            System.out.printf("Player %s, please put your moves\n", driver.getPlayer(driver.currentPlayerId));
            x = in.nextInt();
            y = in.nextInt();
            driver.run(x, y);
        }
        in.close();
    }

    void run(int x, int y) {
        //TODO: Add validations for moves
        board.updateBoard(x, y, moves[currentPlayerId]);
        currentPlayerId = 1 - currentPlayerId;
        totalMoves--;
        board.showBoard();
    }

    Player getPlayer(int id) {
        return players[id];
    }
}
