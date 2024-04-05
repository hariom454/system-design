package org.example.repositories;

import java.util.HashMap;
import org.example.dtos.Sprint;
import org.example.dtos.Task;
import org.example.dtos.User;

//this is to store data in memory
public class InMemoryRepo {

  HashMap<String, Sprint> sprints = new HashMap<>();
  HashMap<String, Task> tasks = new HashMap<>();
  HashMap<String, User> users = new HashMap<>();

  private static InMemoryRepo INSTANCE;

  private InMemoryRepo() {
  }

  public static InMemoryRepo getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new InMemoryRepo();
    }

    return INSTANCE;
  }

  public Task saveTask(Task task) {
    tasks.put(task.getId(), task);
    return task;
  }

  public Task getTask(String id){
    if(tasks.containsKey(id)){
      return tasks.get(id);
    }
    throw new RuntimeException("task not found");
  }

  public Sprint saveSprint(Sprint sprint) {
    sprints.put(sprint.getId(), sprint);
    return sprint;
  }

  public User saveUser(User user) {
    users.put(user.getId(), user);
    return user;
  }
}
