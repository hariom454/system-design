package org.example.models;

public class Player {

  private String name;
  private int position;

  public Player(String name, int initialPosition) {
    this.name = name;
    this.position = initialPosition;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        '}';
  }
}
