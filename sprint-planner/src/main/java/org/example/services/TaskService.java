package org.example.services;

import java.util.List;
import java.util.concurrent.Semaphore;
import org.example.dtos.Task;
import org.example.dtos.TaskStatus;
import org.example.dtos.TaskType;
import org.example.dtos.User;
import org.example.repositories.InMemoryRepo;

//Handles operations on task
public class TaskService {

  UserService userService = new UserService();
  InMemoryRepo inMemoryRepo = InMemoryRepo.getInstance();

  public Task getTask(String id) {
    //check for id null/not null etc would be added either in controller layer or application layer for production system
    Task task = inMemoryRepo.getTask(id);
    if (task != null) {
      System.out.printf("Task with given id found in db: %s\n", id);
      return task;
    }
    System.out.printf("Task with given id not found in db: %s", id);
    //not found exception would be thrown
    throw new RuntimeException("Task not found in db");

  }

  public Task create(String taskType, String summary) {
    //validation for task type should be added in task type enum with proper null and error handling
    TaskType taskT = TaskType.valueOf(taskType);
    Task task = new Task(taskT, summary);
    System.out.printf("New task created with id: %s and type: %s\n", task.getId(), taskType);
    inMemoryRepo.saveTask(task);
    return task;
  }

  public void assignTask(String id, String userId) {
    Task task = getTask(id);
    User user = userService.getUser(userId);
    if (task.getSprintId() == null) {
      task.setAssignedTo(userId);
      return;
    }
    //check for task status and how many task users have in progress
    //if it's more than two don't allow
    List<Task> userTasks = user.getTasks();
    //filter all the tasks with in progess in given sprint
  }

  public void changesStatus(String taskId, String status) {
    TaskStatus taskStatus = TaskStatus.valueOf(status);
    Task task = getTask(taskId);

    String id = task.getAssignedTo();
    User user = userService.getUser(id);
    TaskStatus currentStatus = task.getStatus(); // value of
    if ((currentStatus == TaskStatus.TODO && taskStatus == TaskStatus.INPROGRESS) || (
        currentStatus == TaskStatus.INPROGRESS && taskStatus == TaskStatus.TODO) || (
        currentStatus == TaskStatus.INPROGRESS && taskStatus == TaskStatus.DONE)) {
      //updateFun(
      //check how many task user have which are in inprogress in same sprint
      System.out.println("Updated task status");
      //add
      //task finish time
      //edges[0] = { inprogerss, codereview}
      //todo -> inprogress, codereview
      //inprogress
      task.setStatus(taskStatus);
    }
    throw new RuntimeException("Invalid status update");
  }


}
