package main.java.com.model;

public class User {
    private String Username;
    private String Password;
    private String email;

    public User(String username, String password, String email) {
        this.Username = username;
        this.Password = password;
        this.email = email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    public String getEmail() {
        return email;
    }







}
