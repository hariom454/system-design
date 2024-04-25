package org.example.models;

public class Move {

  private int initialPosition;
  private int finalPosition;
  private Player player;

  public Move(int initialPosition, int finalPosition, Player player) {
    this.initialPosition = initialPosition;
    this.finalPosition = finalPosition;
    this.player = player;
  }

  public int getInitialPosition() {
    return initialPosition;
  }

  public void setInitialPosition(int initialPosition) {
    this.initialPosition = initialPosition;
  }

  public int getFinalPosition() {
    return finalPosition;
  }

  public void setFinalPosition(int finalPosition) {
    this.finalPosition = finalPosition;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  @Override
  public String toString() {
    return "Move{" +
        "initialPosition=" + initialPosition +
        ", finalPosition=" + finalPosition +
        ", player=" + player +
        '}';
  }
}
