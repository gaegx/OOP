package main.java.com.model;

public class User {
    private String Username;
    private String Password;
    private String email;
    private  String walletnumber;

    public User(String username, String password, String email, String walletnumber) {
        this.Username = username;
        this.Password = password;
        this.email = email;
        this.walletnumber = walletnumber;
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
