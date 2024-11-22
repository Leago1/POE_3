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
public class TaskManagerTest {
    
    public TaskManagerTest() {
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
     * Test of showTaskManagerMenu method, of class TaskManager.
     */
    @Test
    public void testShowTaskManagerMenu() {
        System.out.println("showTaskManagerMenu");
    TaskManager instance = new TaskManager();
    assertDoesNotThrow(() -> instance.showTaskManagerMenu());
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() {
        // Clear the task list before testing
        Tasks.getTaskList().clear(); 
        TaskManager manager = new TaskManager();

        // Add task using parameters directly
        manager.addTask("Task1", "Developer", 5, "To Do", "Sample description");

        // Check if the task was added to the list
        assertEquals(1, Tasks.getTaskList().size());

        // Optionally, check if the task details are correct
        Tasks task = Tasks.getTaskList().get(0);
        assertEquals("Task1", task.getTaskName());
        assertEquals("Developer", task.getDeveloperDetails());
        assertEquals(5, task.getTaskDuration());
        assertEquals("To Do", task.getTaskStatus());
    }
    
}
