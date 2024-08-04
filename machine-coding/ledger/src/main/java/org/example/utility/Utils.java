package org.example.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.example.services.LedgerService;

public class Utils {

  private static Long cnt = 1L;

  public static Long getUniqueId() {
    return cnt++;
  }

  public static void processInput(LedgerService ledgerService, String fileName)
      throws FileNotFoundException {
    Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
    while (sc.hasNext()) {
      String line = sc.nextLine();
      performTask(ledgerService, line);
    }
  }

  private static void performTask(LedgerService ledgerService, String line) {
    String[] inputs = line.split(" ");
    switch (inputs[0]) {
      case "LOAN": {
        int pa = Integer.parseInt(inputs[3]);
        int t = Integer.parseInt(inputs[4]);
        int r = Integer.parseInt(inputs[5]);
        ledgerService.borrowMoney(inputs[1], inputs[2], pa, t, r);
        break;
      }
      case "PAYMENT": {
        int lumpSum = Integer.parseInt(inputs[3]);
        int no = Integer.parseInt(inputs[4]);
        ledgerService.repayment(inputs[1], inputs[2], lumpSum, no);
        break;
      }
      case "BALANCE": {
        int emi = Integer.parseInt(inputs[3]);
        ledgerService.showBalance(inputs[1], inputs[2], emi);
        break;
      }
    }
  }
}
