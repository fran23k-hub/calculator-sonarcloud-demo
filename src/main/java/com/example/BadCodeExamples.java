package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;

public class BadCodeExamples {

    // FIX 1: Removed hardcoded password
    public static String PASSWORD = System.getenv("APP_PASSWORD");

    public void unusedMethod() {
        // Still intentionally unused
    }

    public int divideNumbers(int a, int b) {
        return a / b;
    }

    // FIX 2: Added null check
    public void nullPointerExample(String str) {
        if (str != null && str.length() > 5) {
            System.out.println(str);
        }
    }

    // FIX 3: Add diamond operator
    public List<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }

    public void infiniteLoop() {
        while (false) {
            System.out.println("This will run forever");
        }
    }

    public void duplicateCode() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Duplicate code: " + i);
        }
        // Leaving duplicate intentionally for the lab
    }

    public void unusedVariable() {
        int unused = 42;
    }

    public void emptyTryCatchBlock() {
        try {
            // Some code that might throw an exception
        } catch (Exception e) {
            // FIX: Log instead of empty catch
            System.err.println(e.getMessage());
        }
    }

    // FIX 4: Replace string concatenation with StringBuilder
    public String concatenateStrings(List<String> strings) {
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }
        return result.toString();
    }

    // FIX 5: Prepared statement to avoid SQL injection
    public void sqlInjectionVulnerability(String userInput) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            String query = "SELECT * FROM users WHERE username = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, userInput);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void weakEncryption(String password) {
        String encoded = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println("Encoded: " + encoded);
    }

    public void unsafeDeserialization(byte[] data) {
        try {
            var ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(data));
            Object obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
