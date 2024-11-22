/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepartthr33;
import javax.swing.JOptionPane;
/**
 *
 * @author LEAG000
 */
public class POEPARTTHR33 {

    public static void main(String[] args) {
        POEPARTTHR33 app = new POEPARTTHR33();

        // Registration
        JOptionPane.showMessageDialog(null, "Welcome! Please register to continue.");
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username;
        String password;

        // Loop until valid username and password are entered
        while (true) {
            username = JOptionPane.showInputDialog("Enter username (must contain an underscore and be no more than 5 characters):");
            password = JOptionPane.showInputDialog("Enter password (must be at least 8 characters, contain an uppercase letter, a number, and a special character):");

            String registrationMessage = app.registerUser (username, password);
            if (registrationMessage.equals("Registration successful!")) {
                JOptionPane.showMessageDialog(null, registrationMessage);
                break; // Exit the loop if registration is successful
            } else {
                JOptionPane.showMessageDialog(null, registrationMessage); // Show error message
            }
        }

        JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it's great to see you.");

        // User login
        boolean loggedIn = false;
        while (!loggedIn) {
            String loginUsername = JOptionPane.showInputDialog("Enter username:");
            String loginPassword = JOptionPane.showInputDialog("Enter password:");

            String loginMessage = app.returnLoginStatus(loginUsername, loginPassword, username, password);
            JOptionPane.showMessageDialog(null, loginMessage);

            if (loginMessage.startsWith("Welcome")) {
                loggedIn = true;
            }
        }

        // Main menu after successful login
        TaskManager taskManager = new TaskManager();
        boolean running = true;
        while (running) {
            String menuMessage = "Welcome to EasyKanban\nSelect an option:\n1) Add tasks\n2) Show report\n3) Task Manager\n4) Quit";
            String choiceInput = JOptionPane.showInputDialog(menuMessage);

            if (choiceInput != null && choiceInput.matches("[1-4]")) {
                int choice = Integer.parseInt(choiceInput);
                switch (choice) {
                    case 1:
                        taskManager.addTask();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 3:
                        taskManager.showTaskManagerMenu();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Leaving EasyKanban. Thank you, Goodbye!");
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, 3, or 4.");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }

    // Registration and login methods
    public String registerUser (String username, String password) {
        if (!isValidUsername(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (!isValidPassword(password)) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        return "Registration successful!";
    }

    public boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasDigit && hasSpecialChar;
    }

    public String returnLoginStatus(String loginUsername, String loginPassword, String registeredUsername, String registeredPassword) {
        if (loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)) {
            return "Welcome " + registeredUsername + "!";
        } else {
            return "Username or password is incorrect. Please try again.";
        }
    }
}