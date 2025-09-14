package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  private String name;
  private final Map<Account, Loan> loans;

  public Bank(String name) {
    this.name = name;
    loans = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public void borrowMoney(Account account, int pa, int t, int i) {
    Loan loan = new Loan(pa, i, t);
    loans.put(account, loan);
  }

  public Loan getLoan(Account account) {
    return loans.get(account);
  }

  public void repayment(Account account, int lumpSump, int emi) {
    Loan loan = getLoan(account);
    loan.repayment(lumpSump, emi);
  }

  public Balance getBalance(Account account, int emi) {
    Loan loan = getLoan(account);
    return loan.calculateBalance(emi);
  }

}
