package org.example.metrocard.models;

import java.util.List;
import org.example.metrocard.utils.Pair;

public interface MetroStation {

  int getTotalCollection();

  int getTotalDiscount();

  List<Pair> getPassengerSummary();

  void checkin(Journey j);

  String getStationName();
}


