package org.example.services;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Account;
import org.example.models.Bank;
import org.example.models.Loan;

public class BankService {

  private Map<String, Bank> bankMap;
  private LoanService loanService;

  public BankService() {
    this.bankMap = new HashMap<>();
    loanService = new LoanService();
  }

  public boolean doesBankExist(String bankName) {
    return bankMap.containsKey(bankName);
  }

  public Bank getBank(String bankName) {
    return bankMap.get(bankName);
  }

  public void addBank(Bank bank) {
    bankMap.put(bank.getName(), bank);
  }

  public Loan borrowMoney(Account account, int pa, int t, int i) {
    Loan loan = new Loan(pa, i, t);
    loanService.addLoan(account, loan);
    return loan;
  }
}
