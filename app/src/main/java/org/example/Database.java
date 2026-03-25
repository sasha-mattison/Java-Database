package org.example;

import java.io.IOException;
import java.util.HashMap;
//import java.nio.file.*;

public class Database {

    private File databaseFile;
    private File users;
    private File passwords;
    private String location;
    private User[] accountList;
    private HashMap<String, String> userMap = new HashMap<>();
    private String[] userList;
    private String[] passwordList;

    public Database(String location) {
        this.location = location;
    }

    void main() {
        
    }

    void init() {

        databaseFile = new File(this.location + "database.data");
        users = new File(location + "users.json");
        passwords = new File(location + "passwords.json");

        try {
            databaseFile.create();
            users.create();
            passwords.create();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setupUserMap();
    }

    void test() {
        try {
        databaseFile.formatWrite("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void checkUser(String username, String password) {
         for (int i = 0; i < Math.min(userList.length, passwordList.length); i++) {
            userMap.put(userList[i].trim(), passwordList[i].trim());
        }

        String passwordToCheckAgainst = userMap.get(username);
        if (!password.equals(passwordToCheckAgainst))
            return;

        System.out.println("User is logged in");
    }

    private void setupUserMap() {
        try {
            int userNum = Math.min(users.read().split(",").length, passwords.read().split(",").length);
            userList = users.read().split(",");
            passwordList = passwords.read().split(",");
            for (int i = 0; i<userNum; i++) {
                userMap.put(userList[i], passwordList[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void newUser(String username, String password) {
        userMap.put(username, password);
        try {
            users.formatWrite(username);
            passwords.formatWrite(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
