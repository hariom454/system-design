package org.example.snakeladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
  private final int dimension;
  private List<SpecialEntity> specialItems;
  Map<Integer, SpecialEntity>


  public Board(int dimension) {
    this.dimension = dimension;
    specialItems = new ArrayList<>();
  }

  private void addSpecialEntity(SpecialEntity entity){
    specialItems.add(entity);
  }
  private List<SpecialEntity> getSpecialItems(){
    return specialItems;
  }

  private boolean hasSpecialItem(int pos){

  }
}
