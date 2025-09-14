package org.example.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.example.utils.Utils;

/**
 * Data class to represent sprint board
 */
public class Sprint {

  String id; //sprint-unique id for records => uuid
  String name; //visual representation of sprint e.g. sprint-1, or sprint 24-1
  String createdBy; //optional for track purpose
  String createdAt; //timestamp
  String startDate;
  String endDate;

  List<Task> tasks;

  public Sprint(String name) {
    this.id = Utils.getUniqueId();
    this.name = name;
    this.createdAt = Utils.getTimeStamp();
    this.tasks = new ArrayList<>();
    //rest fields could be added if required
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sprint sprint = (Sprint) o;
    return Objects.equals(id, sprint.id) && Objects.equals(name, sprint.name)
        && Objects.equals(createdBy, sprint.createdBy) && Objects.equals(
        createdAt, sprint.createdAt) && Objects.equals(startDate, sprint.startDate)
        && Objects.equals(endDate, sprint.endDate) && Objects.equals(tasks,
        sprint.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createdBy, createdAt, startDate, endDate, tasks);
  }

  @Override
  public String toString() {
    return "Sprint{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", createdBy='" + createdBy + '\'' +
        ", createdAt='" + createdAt + '\'' +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", tasks=" + tasks +
        '}';
  }
}
