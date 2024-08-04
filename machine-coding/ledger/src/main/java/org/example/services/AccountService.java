package org.example.services;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Account;

public class AccountService {

  Map<String, Account> accountMap;

  public AccountService() {
    this.accountMap = new HashMap<>();
  }

  public Account getAccount(String username) {
    return accountMap.get(username);
  }

  public void addAccount(Account account) {
    accountMap.put(account.getUserName(), account);
  }

  public boolean userExists(String username) {
    return accountMap.containsKey(username);
  }
}
