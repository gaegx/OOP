package main.java.com.model;

public class User {
    private String Username;
    private String Password;
    private String email;
    private int walletnumber;
    private int balance;
    private CryptoList wallet=new CryptoList();


    public User(String username, String password, String email, int walletnumber,int balance) {
        this.Username = username;
        this.Password = password;
        this.email = email;
        this.walletnumber = walletnumber;
        this.balance = balance;
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

    public int getBalance() {
        return balance;
    }
    public CryptoList getCryptoList() {
        return wallet;
    }

    public void setCryptoList(CryptoList cryptoList) {
        if (cryptoList != null) {
            this.wallet = cryptoList;
        } else {
            this.wallet = new CryptoList(); // Если передан null, создаем пустой список
        }
    }



}
