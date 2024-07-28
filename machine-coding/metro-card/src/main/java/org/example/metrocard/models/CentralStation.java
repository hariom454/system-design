package org.example.metrocard.models;

import java.util.List;
import org.example.metrocard.utils.Pair;

public class CentralStation implements MetroStation {
  private int totalCollection;


  @Override
  public int getTotalCollection() {
    return 0;
  }

  @Override
  public List<Pair> getPassengerSummary() {
    return null;
  }
}
