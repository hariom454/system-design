package org.example.dtos;

import java.util.ArrayList;
import java.util.List;
import org.example.utils.Utils;

public class User {
  String id;
  String firstName;
  String lastName;
  String createdAt;
  String updatedAt;
  String status; //active - deactive
  //Any other field which could be usable for our reference
  List<Task> tasks;

  public User(String firstName) {
    this.id = Utils.getUniqueId();
    this.firstName = firstName;
    tasks = new ArrayList<>();
    this.createdAt = Utils.getTimeStamp();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        ", status='" + status + '\'' +
        ", tasks=" + tasks +
        '}';
  }
}
