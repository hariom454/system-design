package org.example;

import org.example.dtos.Sprint;
import org.example.dtos.Task;
import org.example.services.SprintService;
import org.example.services.TaskService;

public class Main {

  public static void main(String[] args) {
    //System.out.println("Hello world!");
    System.out.println("Starting the card service, specify operation as asked");

    SprintService sprintService = new SprintService();
    TaskService taskService = new TaskService();

    //create and get sprint
    Sprint sprint = sprintService.createSprint("hariom");
    sprintService.getSprint(sprint.getId());

    //create task and get task
    Task task = taskService.create("STORY", "creating a task for testing");
    taskService.getTask(task.getId());

    sprintService.addTask(sprint.getId(), task.getId());

  }
}