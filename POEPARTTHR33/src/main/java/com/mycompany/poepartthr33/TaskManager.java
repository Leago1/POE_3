/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartthr33;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author LEAG000
 */
public class TaskManager {
    // Task management options and the task list from the Tasks class
    public void showTaskManagerMenu() {
         boolean running = true;
        while (running) {
            String menu = "Task Manager Menu:\n" +
                    "1. Add Task\n" +
                    "2. Display Done Tasks\n" +
                    "3. Display Longest Task\n" +
                    "4. Search Task by Name\n" +
                    "5. Search Tasks by Developer\n" +
                    "6. Delete Task\n" +
                    "7. Display All Tasks\n" +
                    "8. Back to Main Menu\n" +
                    "Choose an option:";

            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null) break;

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    displayDoneTasks();
                    break;
                case "3":
                    displayLongestTask();
                    break;
                case "4":
                    searchTaskByName();
                    break;
                case "5":
                    searchTasksByDeveloper();
                    break;
                case "6":
                    deleteTask();
                    break;
                case "7":
                    displayAllTasks();
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    // Method to add a task
    public void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String developer = JOptionPane.showInputDialog("Enter Developer Name:");
        String durationInput = JOptionPane.showInputDialog("Enter Task Duration (in hours):");
        String taskStatus = JOptionPane.showInputDialog("Enter Task Status (e.g., 'Pending', 'Done'):");

        int taskDuration = 0;
        try {
            taskDuration = Integer.parseInt(durationInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid duration input. Please enter a valid number.");
            return; // Exit if invalid input
        }

        String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");

        addTask(taskName, developer, taskDuration, taskStatus, taskDescription);
    }

    // Overloaded method to add a task with parameters
    public void addTask(String taskName, String developer, int taskDuration, String taskStatus, String taskDescription) {
        // Create task only if description is valid
        if (Tasks.checkTaskDescription(taskDescription)) {
            // Create the task object
            Tasks task = new Tasks(taskName, developer, taskDuration, taskStatus); // Adjust constructor as needed
            // Add the task to the task list
            Tasks.addTaskToList(task);
            JOptionPane.showMessageDialog(null, "Task successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "Task description is too short. Please enter a description with more than 10 characters.");
        }
    }

    private void deleteTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
        Iterator<Tasks> iterator = Tasks.getTaskList().iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Tasks task = iterator.next();
            if (task.getTaskName().equals(taskName)) {
                iterator.remove();
                deleted = true;
                break;
            }
        }
        JOptionPane.showMessageDialog(null, deleted ? "Task successfully deleted." : "Task not found.");
    }

    private void displayAllTasks() {
        StringBuilder allTasks = new StringBuilder("All Tasks:\n");
        for (Tasks task : Tasks.getTaskList()) {
            allTasks.append(task.printTaskDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(null, allTasks.toString());
    }

    // Placeholder methods for other functionalities
    private void displayDoneTasks() {
        // Implement display logic for done tasks
    }

    private void displayLongestTask() {
        // Implement display logic for longest task
    }

    private void searchTaskByName() {
        // Implement search logic by task name
    }

    private void searchTasksByDeveloper() {
        // Implement search logic by developer name
    }
}