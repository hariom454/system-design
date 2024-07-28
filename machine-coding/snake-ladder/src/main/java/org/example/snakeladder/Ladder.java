package org.example.snakeladder;

import org.example.utils.Utils;

public class Ladder implements SpecialEntity {

  private final int start;
  private final int end;
  private final String id;

  public Ladder(int start, int end) {
    this.start = start;
    this.end = end;
    this.id = Utils.getUniqueId();
  }

  @Override
  public int getStartPosition() {
    return start;
  }

  @Override
  public int getEndPosition() {
    return end;
  }

  @Override
  public String getId() {
    return id;
  }
}
