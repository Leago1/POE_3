/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartthr33;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LEAG000
 */
public class Tasks {
         // Task properties
    private String taskName;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;

    // Static list to hold all tasks
    private static ArrayList<Tasks> taskList = new ArrayList<>();

    // Constructor to initialize task details
    public Tasks(String taskName, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    // Getter methods for task details
    public String getTaskName() {
        return taskName;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    // Method to add task to the list
    public static void addTaskToList(Tasks task) {
        taskList.add(task);
    }

    // Method to retrieve the list of tasks
    public static ArrayList<Tasks> getTaskList() {
        return taskList;
    }

    // Method to check if task description is valid (i.e., has more than 10 characters)
    public static boolean checkTaskDescription(String description) {
        return description != null && description.length() > 10;
    }

    // Method to calculate total hours of all tasks
    public static int returnTotalHours() {
        int totalHours = 0;
        for (Tasks task : taskList) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Name: " + taskName + ", Developer: " + developerDetails + ", Duration: " + taskDuration + ", Status: " + taskStatus;
    }

    // Static method for task description validation
    public static boolean validateTaskDescription(String description) {
        return description.length() > 10; // Valid if the description is longer than 10 characters
    }

}
