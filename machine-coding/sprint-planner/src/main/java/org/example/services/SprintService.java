package org.example.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.example.dtos.Sprint;
import org.example.dtos.Task;
import org.example.repositories.InMemoryRepo;

//Handles operations on sprint
public class SprintService {

  HashMap<String, Sprint> sprints = new HashMap<>();
  TaskService taskService = new TaskService();
  InMemoryRepo inMemoryRepo = InMemoryRepo.getInstance();

  public Sprint getSprint(String id) {
    if (sprints.containsKey(id)) {
      System.out.printf("Sprint with given id found in db: %s\n", id);
      return sprints.get(id);
    }
    System.out.println("Sprint with given id doesn't exist");
    //application would throw error here: custom not found exception 404
    throw new RuntimeException("Sprint with given id not found");
  }

  public Sprint createSprint(String name) {

    Sprint sprint = new Sprint(name);
    // logger(sl4j) would be added in production application for printing logs sync/async manner
    System.out.printf("Sprint is created with name: %s, id: %s\n", name, sprint.getId());
    //repository layer would be dealing with storing information
    //for simplicity keeping it here
    sprints.put(sprint.getId(), sprint);
    return sprint;
  }

  public void addTask(String id, String taskId) {
    Sprint sprint = getSprint(id);
    //check if task already exists
    List<Task> tasks = sprint.getTasks();
    if (tasks.size() >= 20) {
      //Bad request needs to be thrown
      throw new RuntimeException("Max allowed limit for sprint reached");
    }
    Task task = tasks.stream().filter(item -> item.getId() == taskId).findAny().orElse(null);
    //we can also check task is already present in sprint or not if
    if (task != null) {
      throw new RuntimeException("Task is already part of sprint");
    } else {
      Task task1 = taskService.getTask(taskId);
      tasks.add(task1);
      task1.setSprintId(id);
      //add check for inprogress task limit for a user
      System.out.println("Task has been added to sprint");
    }
  }

  List<Task> getDelayedTasks(String id, String endDate) {
    Sprint sprint = getSprint(id);
    List<Task> tasks = sprint.getTasks();
    //filter task -> add compare utility functoin in utils for time
    List<Task> delayedTask = new ArrayList<>();
    tasks.stream().forEach(task -> {
      //Instant.parse(task.getFinishedAt())
      //co'mpare using utlity
      //1. done task
      //

    });

    return delayedTask;
  }

}
