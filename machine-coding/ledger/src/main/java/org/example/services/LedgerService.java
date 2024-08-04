package org.example.services;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Account;
import org.example.models.Balance;
import org.example.models.Bank;
import org.example.models.Loan;

public class LedgerService {

  private AccountService accountService;
  private BankService bankService;

  public LedgerService() {
    this.accountService = new AccountService();
    this.bankService = new BankService();
  }

  public void borrowMoney(String bankName, String borrowerName, int pa, int t, int i) {
    Bank bank = getOrAddBank(bankName);
    Account account = getOrAddAccount(borrowerName);
    bank.borrowMoney(account,pa, t, i);

  }

  private Bank getOrAddBank(String bankName) {
    Bank bank;
    if (!bankService.doesBankExist(bankName)) {
      bank = new Bank(bankName);
      bankService.addBank(bank);
    } else {
      bank = bankService.getBank(bankName);
    }
    return bank;
  }

  private Account getOrAddAccount(String userName) {
    Account account;
    if (!accountService.userExists(userName)) {
      account = new Account(userName);
      accountService.addAccount(account);
    } else {
      account = accountService.getAccount(userName);
    }
    return account;
  }

  public void repayment(String bankName, String borrowerName, int lAmount, int emiNo) {

    Bank bank = getOrAddBank(bankName);
    Account account = getOrAddAccount(borrowerName);
    bank.repayment(account, lAmount, emiNo);
  }

  public void showBalance(String bankName, String borrowName, int emi) {
    Bank bank = getOrAddBank(bankName);
    Account account = getOrAddAccount(borrowName);
    Balance balance = bank.getBalance(account, emi);
    balance.setBankName(bankName);
    balance.setUserName(borrowName);
    printBalance(balance);
  }

  private void printBalance(Balance balance) {
    System.out.printf("%s %s %s %s%n", balance.getBankName(), balance.getUserName(),
        balance.getRepaymentAmount(), balance.getRemainingEmi());
  }
}
