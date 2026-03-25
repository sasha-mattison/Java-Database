package org.example;

public class User {
    
    private String username;
    private String password;
    private String encryptionKey;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return this.username;
    }

    String getPassword() {
        return this.password;
    }

    
    
}
