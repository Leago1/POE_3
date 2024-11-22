/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepartthr33;

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
public class POEPARTTHR33Test {
    
    public POEPARTTHR33Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class POEPARTTHR33.
     */
    @Test
    public void testMain() {
        System.out.println("main");
    String[] args = {};
    assertDoesNotThrow(() -> POEPARTTHR33.main(args));
}
    /**
     * Test of registerUser method, of class POEPARTTHR33.
     */
    @Test
    public void testRegisterUser() {
            System.out.println("registerUser");
    POEPARTTHR33 instance = new POEPARTTHR33();
    String username = "testUser";
    String password = "Test123!";
    String result = instance.registerUser(username, password);
    assertEquals("Registration successful!", result); // Adjust expected result as per actual logic.

    }

    /**
     * Test of isValidUsername method, of class POEPARTTHR33.
     */
    @Test
    public void testIsValidUsername() {
        System.out.println("isValidUsername");
    POEPARTTHR33 instance = new POEPARTTHR33();
    assertTrue(instance.isValidUsername("validUser123"));
    assertFalse(instance.isValidUsername("invalid user"));
    }

    /**
     * Test of isValidPassword method, of class POEPARTTHR33.
     */
    @Test
    public void testIsValidPassword() {
       System.out.println("isValidPassword");
    POEPARTTHR33 instance = new POEPARTTHR33();
    assertTrue(instance.isValidPassword("Secure123!"));
    assertFalse(instance.isValidPassword("123"));
    }

    /**
     * Test of returnLoginStatus method, of class POEPARTTHR33.
     */
    @Test
    public void testReturnLoginStatus() {
     POEPARTTHR33 app = new POEPARTTHR33();
    assertEquals("Welcome user_!", app.returnLoginStatus("user_", "Password1!", "user_", "Password1!"));
    assertEquals("Username or password is incorrect. Please try again.", app.returnLoginStatus("user", "pass", "user_", "Password1!"));
    }
     // Task-related methods
    // Test for adding and getting tasks
    @Test
    public void testAddTask() {
        System.out.println("addTask");

        // Create a task and add it to the task list
        Tasks task = new Tasks("New Task", "Developer", 5, "To Do");
        Tasks.addTaskToList(task);

        // Verify if the task is added correctly
        assertEquals(1, Tasks.getTaskList().size()); // Ensure there is one task in the list
        assertEquals("New Task", Tasks.getTaskList().get(0).getTaskName());
    }

    // Test for getting the task list
    @Test
    public void testGetTaskList() {
        System.out.println("getTaskList");

        // Adding tasks to the list
        Tasks task1 = new Tasks("Task1", "Developer", 5, "To Do");
        Tasks task2 = new Tasks("Task2", "Tester", 3, "In Progress");
        Tasks.addTaskToList(task1);
        Tasks.addTaskToList(task2);

        // Verifying the task list
        assertEquals(2, Tasks.getTaskList().size());
        assertEquals("Task1", Tasks.getTaskList().get(0).getTaskName());
        assertEquals("Task2", Tasks.getTaskList().get(1).getTaskName());
    }

    // Test for checking task description
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");

        // Check valid and invalid task descriptions
        assertTrue(Tasks.checkTaskDescription("This is a valid description."));
        assertFalse(Tasks.checkTaskDescription("Too short"));
    }

    // Test for returnTotalHours method
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");

        // Adding tasks with durations
        Tasks task1 = new Tasks("Task1", "Developer", 5, "To Do");
        Tasks task2 = new Tasks("Task2", "Tester", 3, "In Progress");
        Tasks task3 = new Tasks("Task3", "Developer", 2, "Completed");
        Tasks.addTaskToList(task1);
        Tasks.addTaskToList(task2);
        Tasks.addTaskToList(task3);

        // Verifying total hours calculation
        assertEquals(10, Tasks.returnTotalHours()); // 5 + 3 + 2 = 10 hours
    }

    // Test for printing task details
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");

        // Create a task and check its details
        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        String expectedDetails = "Task Name: Task1, Developer: Developer, Duration: 5, Status: To Do";
        assertEquals(expectedDetails, task.printTaskDetails());
    }

    // Test for getting task name and developer details
    @Test
    public void testTaskDetails() {
        System.out.println("getTaskDetails");

        Tasks task = new Tasks("Task1", "Developer", 5, "To Do");
        assertEquals("Task1", task.getTaskName());
        assertEquals("Developer", task.getDeveloperDetails());
    }
}
