package org.example.services;

import org.example.models.Account;
import org.example.models.Balance;
import org.example.models.Bank;

public class LedgerService {

  private final AccountService accountService;
  private final BankService bankService;

  public LedgerService() {
    this.accountService = new AccountService();
    this.bankService = new BankService();
  }

  public void borrowMoney(String bankName, String borrowerName, int pa, int t, int i) {
    Bank bank = getOrAddBank(bankName);
    Account account = getOrAddAccount(borrowerName);
    bank.borrowMoney(account, pa, t, i);

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

    Bank bank = bankService.getBank(bankName);
    Account account = accountService.getAccount(borrowerName);
    bank.repayment(account, lAmount, emiNo);
  }

  public void showBalance(String bankName, String borrowName, int emi) {
    Bank bank = bankService.getBank(bankName);
    Account account = accountService.getAccount(borrowName);
    Balance balance = bank.getBalance(account, emi);
    printBalance(bankName, borrowName, balance);
  }

  private void printBalance(String bankName, String userName, Balance balance) {
    System.out.printf("%s %s %s %s%n", bankName, userName,
        balance.getRepaymentAmount(), balance.getRemainingEmi());
  }
}
