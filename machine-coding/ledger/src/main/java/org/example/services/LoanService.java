package org.example.services;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Account;
import org.example.models.Loan;

public class LoanService {

  private Map<Account, Loan> loans;

  public LoanService() {
    this.loans = new HashMap<>();
  }

  public void addLoan(Account account, Loan loan) {
    loans.put(account, loan);
  }

  public Loan getLoan(Account account) {
    return loans.get(account);
  }
}
