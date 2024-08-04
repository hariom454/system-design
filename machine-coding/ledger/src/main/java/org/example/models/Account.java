package org.example.models;

import org.example.utility.Utils;

public class Account {

  private final Long number;
  private final String userName;

  public Account(String userName) {
    this.number = Utils.getUniqueId();
    this.userName = userName;
  }

  public Long getNumber() {
    return number;
  }

  public String getUserName() {
    return userName;
  }
}
