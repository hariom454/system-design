package org.shashtra.models;

public class User {

  String userId;
  String name;
  String emailId;
  String mobileNumber;

  public User(String userId, String name, String emailId, String mobileNumber) {
    this.userId = userId;
    this.name = name;
    this.emailId = emailId;
    this.mobileNumber = mobileNumber;
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public String getEmailId() {
    return emailId;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", name='" + name + '\'' +
        ", emailId='" + emailId + '\'' +
        ", mobileNumber='" + mobileNumber + '\'' +
        '}';
  }
}
