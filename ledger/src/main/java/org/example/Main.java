package org.example;

import java.io.FileNotFoundException;
import org.example.services.LedgerService;
import org.example.utility.Utils;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    String fileName = args[0];
    LedgerService ledgerService = new LedgerService();
    Utils.processInput(ledgerService, fileName);
  }
}