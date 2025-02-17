package main.java.com.model.Tokens;

import main.java.com.model.Token;

public class Stablecoin extends Token {
    private String peggedCurrency;

    private Stablecoin(String name, String symbol, double value, String contractAddress, String peggedCurrency) {
        super(name, symbol, contractAddress, value);
        this.peggedCurrency = peggedCurrency;
    }





}