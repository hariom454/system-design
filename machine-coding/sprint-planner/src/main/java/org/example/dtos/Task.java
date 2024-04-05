package org.example.dtos;

import java.util.Objects;
import org.example.utils.Utils;

public class Task {

  String id; //task id
  TaskType taskType;
  String summary;
  String description;
  String assignedTo; // user assigned to
  TaskStatus status;
  String createdAt;
  String startedAt;
  String finishedAt;
  String dueDate;
  String sprintId;


  public Task(TaskType taskType, String summary) {
    this.id = Utils.getUniqueId();
    this.taskType = taskType;
    this.summary = summary;
    this.status = TaskStatus.TODO;
    this.createdAt = Utils.getTimeStamp();
    //we can have constructor with due date, assignedTo as well
  }

  public String getSprintId() {
    return sprintId;
  }

  public void setSprintId(String sprintId) {
    this.sprintId = sprintId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TaskType getTaskType() {
    return taskType;
  }

  public void setTaskType(TaskType taskType) {
    this.taskType = taskType;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(String startedAt) {
    this.startedAt = startedAt;
  }

  public String getFinishedAt() {
    return finishedAt;
  }

  public void setFinishedAt(String finishedAt) {
    this.finishedAt = finishedAt;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(id, task.id) && taskType == task.taskType
        && Objects.equals(summary, task.summary) && Objects.equals(description,
        task.description) && Objects.equals(assignedTo, task.assignedTo)
        && status == task.status && Objects.equals(createdAt, task.createdAt)
        && Objects.equals(startedAt, task.startedAt) && Objects.equals(finishedAt,
        task.finishedAt) && Objects.equals(dueDate, task.dueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, taskType, summary, description, assignedTo, status, createdAt,
        startedAt,
        finishedAt, dueDate);
  }

  @Override
  public String toString() {
    return "Task{" +
        "id='" + id + '\'' +
        ", taskType=" + taskType +
        ", summary='" + summary + '\'' +
        ", description='" + description + '\'' +
        ", assignedTo='" + assignedTo + '\'' +
        ", status=" + status +
        ", createdAt='" + createdAt + '\'' +
        ", startedAt='" + startedAt + '\'' +
        ", finishedAt='" + finishedAt + '\'' +
        ", dueDate='" + dueDate + '\'' +
        ", sprintId='" + sprintId + '\'' +
        '}';
  }
}
