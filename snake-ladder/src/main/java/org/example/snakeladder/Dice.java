package org.example.snakeladder;

public class Dice {

  private final int maxValue;

  public Dice(int maxValue) {
    this.maxValue = maxValue;
  }

  public int rollDice() {
    return (int) (Math.random() * maxValue + 1);
  }

  public int getMaxValue() {
    return maxValue;
  }
}
