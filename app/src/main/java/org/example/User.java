package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class User {

    private String username;
    private String password;
    private String privateEncryptionKey;
    private String publicEncryptionKey = "test";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        privateEncryptionKey = password;
    }

    String getUsername() {
        return this.username;
    }

    String getPassword() {
        return this.password;
    }

    String getPrivateEncryptionKey() {
        return privateEncryptionKey;
    }

    String getPublicEncryptionKey() {
        return publicEncryptionKey;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void encryptFile(File file) {
        try {
            String contents = file.read();
            char[] contentsCharArray = contents.toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void genUserData() {

        File userdata = new File("/resources/" + username + ".data");

        try {
            userdata.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
