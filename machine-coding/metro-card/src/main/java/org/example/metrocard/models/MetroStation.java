package org.example.metrocard.models;

import java.util.List;
import org.example.metrocard.utils.Pair;

public interface MetroStation {

  int getTotalCollection();

  List<Pair> getPassengerSummary();

  void checkin(Passenger p, Journey j, int fare);
}


