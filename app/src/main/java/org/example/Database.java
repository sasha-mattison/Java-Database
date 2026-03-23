package org.example;

import java.io.IOException;
//import java.nio.file.*;

public class Database {

    File databaseFile;
    String location;

    public Database(String location) {
        this.location = location;
    }

    void init() {
        databaseFile = new File(this.location + "database.data");
        try {
            databaseFile.create();
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

    void checkUser(String user) {
        try {
            String fileContents = databaseFile.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
