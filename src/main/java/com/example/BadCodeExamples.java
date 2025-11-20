package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;

public class BadCodeExamples {

    public static String PASSWORD = "mySecretPassword123"; // Security hotspot: Hardcoded credentials

    public void unusedMethod() {
        // Code smell: Unused method
    }

    public int divideNumbers(int a, int b) {
        return a / b; // Bug: Potential division by zero
    }

    public void nullPointerExample(String str) {
        if (str.length() > 5) { // Bug: Potential null pointer dereference
            System.out.println(str);
        }
    }

    public List<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<Integer>(); // Code smell: Diamond operator missing
        return list;
    }

    public void infiniteLoop() {
        while (true) { // Bug: Infinite loop
            System.out.println("This will run forever");
        }
    }

    public void duplicateCode() {
        // Code smell: Duplicate code
        for (int i = 0; i < 10; i++) {
            System.out.println("Duplicate code: " + i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Duplicate code: " + i);
        }
    }

    public void unusedVariable() {
        int unused = 42; // Code smell: Unused variable
    }

    public void emptyTryCatchBlock() {
        try {
            // Some code that might throw an exception
        } catch (Exception e) {
            // Bug: Empty catch block
        }
    }

    public String concatenateStrings(List<String> strings) {
        String result = "";
        for (String s : strings) {
            result += s; // Code smell: Inefficient string concatenation
        }
        return result;
    }

    public void sqlInjectionVulnerability(String userInput) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'"; // Security: SQL Injection
                                                                                       // vulnerability
            conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void weakEncryption(String password) {
        String encoded = Base64.getEncoder().encodeToString(password.getBytes()); // Security: Weak encryption
        System.out.println("Encoded: " + encoded);
    }

    public void unsafeDeserialization(byte[] data) {
        try {
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(data));
            Object obj = ois.readObject(); // Security: Unsafe deserialization
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}