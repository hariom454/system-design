package com.shashtra;

/***************
 **  author: Hariom Singh
 **  Date: 11/03/22
 *****************/
public class Board {
    //TODO Add APIs to check Winner/whether to stop game if no winning move is possible
    private final int side;
    private final char[][] board;

    public Board(int side) {
        this.side = side;
        this.board = new char[side][side];
        init();
    }

    private void init() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++)
                board[i][j] = '-';
        }
    }

    public void showBoard() {
        System.out.println("=======Board Current State==========");

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++)
                System.out.printf("%s ", board[i][j]);
            System.out.println();
        }
    }

    void updateBoard(int x, int y, char val) {
        this.board[x][y] = val;
    }
}
