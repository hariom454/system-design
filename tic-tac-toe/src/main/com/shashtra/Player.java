package com.shashtra;

/***************
 **  author: Hariom Singh
 **  Date: 20/03/22
 *****************/
public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
