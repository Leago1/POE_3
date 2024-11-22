/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepartthr33;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LEAG000
 */
public class TasksTest {
    // Test getTaskList() method
    @Test
    public void testGetTaskList() {
        System.out.println("getTaskList");

        // Setup test tasks
        Tasks task1 = new Tasks("Task1", "Developer", 5, "To Do");
        Tasks task2 = new Tasks("Task2", "Tester", 3, "In Progress");

        // Add tasks to taskList
        Tasks.addTaskToList(task1);
        Tasks.addTaskToList(task2);

        // Retrieve the task list and verify
        ArrayList<Tasks> taskList = Tasks.getTaskList();
        assertNotNull(taskList); // Ensure the list is not null
        assertEquals(2, taskList.size()); // Check if the list has 2 tasks
    }

    // Test getTaskName() method
    @Test
    public void testGetTaskName() {
        System.out.println("getTaskName");

        // Create a task and check its name
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        assertEquals("Task1", task.getTaskName());
    }

    // Test getDeveloperDetails() method
    @Test
    public void testGetDeveloperDetails() {
        System.out.println("getDeveloperDetails");

        // Create a task and check the developer details
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        assertEquals("Developer", task.getDeveloperDetails());
    }

    // Test getTaskDuration() method
    @Test
    public void testGetTaskDuration() {
        System.out.println("getTaskDuration");

        // Create a task and check its duration
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        assertEquals(5, task.getTaskDuration());
    }

    // Test getTaskStatus() method
    @Test
    public void testGetTaskStatus() {
        System.out.println("getTaskStatus");

        // Create a task and check its status
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        assertEquals("To Do", task.getTaskStatus());
    }

    // Test printTaskDetails() method
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");

        // Create a task and check the printed details
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        String expectedDetails = "Task Name: Task1, Developer: Developer, Duration: 5, Status: To Do";
        assertEquals(expectedDetails, task.printTaskDetails());
    }

    // Test checkTaskDescription() method
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");

        // Test description validation
        assertTrue(Tasks.checkTaskDescription("This is a valid description."));
        assertFalse(Tasks.checkTaskDescription("Too short"));
    }

    // Test returnTotalHours() method
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");

        // Create tasks and add them to the list
        Tasks task1 = new Tasks("Task1", "Developer", 5, "To Do");
        Tasks task2 = new Tasks("Task2", "Tester", 3, "In Progress");
        Tasks task3 = new Tasks("Task3", "Developer", 2, "Completed");

        // Add tasks to the list
        Tasks.addTaskToList(task1);
        Tasks.addTaskToList(task2);
        Tasks.addTaskToList(task3);

        // Verify that total hours across all tasks are correctly calculated
        assertEquals(10, Tasks.returnTotalHours());
    }
}
   