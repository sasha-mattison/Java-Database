package org.example;

import java.io.IOException;
import java.util.HashMap;
//import java.nio.file.*;

public class Database {

    private File databaseFile;
    private File users;
    private File passwords;
    private String location;
    private User[] accounts;

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
    }

    void test() {
        try {
        databaseFile.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void checkUser(String username, String password) {
        try {
            String userContents = users.read();
            String passwordContents = passwords.read();
            String[] userList = userContents.split(",");
            String[] passwordList = passwordContents.split(",");
            HashMap<String, String> userMap = new HashMap<>();

            for (int i = 0; i < Math.min(userList.length, passwordList.length); i++) {
                userMap.put(userList[i].trim(), passwordList[i].trim());
            }

            String passwordToCheckAgainst = userMap.get(username);
            if (!password.equals(passwordToCheckAgainst))
                return;

            System.out.println("User is logged in");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authenticateUser(String password) {

    }
}
