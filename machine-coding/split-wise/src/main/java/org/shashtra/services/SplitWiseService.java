package org.shashtra.services;

import java.util.HashMap;
import java.util.Map;
import org.shashtra.models.Balance;

public class SplitWiseService {

  public static SplitWiseService instance;

  private SplitWiseService() {
  }

  public static SplitWiseService getInstance() {
    if (instance == null) {
      instance = new SplitWiseService();
    }
    return instance;
  }
  Map<String, Balance> balanceMap = new HashMap<>();
}
