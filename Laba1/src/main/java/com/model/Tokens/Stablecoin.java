package main.java.com.model.Tokens;

import main.java.com.model.Token;

public class Stablecoin extends Token {
    private String peggedCurrency;

    private Stablecoin(String name, String symbol, double value, double amount, String contractAddress, String peggedCurrency) {
        super(name, symbol, contractAddress, value,amount);
        this.peggedCurrency = peggedCurrency;
    }

    public static Stablecoin createStablecoin(String name, String symbol, double value,double amount,String contractAddress, String peggedCurrency) {
        return new Stablecoin(name,symbol,value,amount,contractAddress,peggedCurrency );
    }

    public String getPeggedCurrency() {
        return peggedCurrency;
    }

    public void setPeggedCurrency(String peggedCurrency) {
        this.peggedCurrency = peggedCurrency;
    }





}