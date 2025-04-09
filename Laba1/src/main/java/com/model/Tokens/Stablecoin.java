package main.java.com.model.Tokens;

import main.java.com.model.Token;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Contract Address:", "Pegged Currency:"})
public class Stablecoin extends Token {
    private String peggedCurrency;

    private Stablecoin(String name, String symbol, double value, double amount, String contractAddress, String peggedCurrency) {
        super(name, symbol, contractAddress, value, amount);
        this.peggedCurrency = peggedCurrency;
    }


    public static Stablecoin Сreate(String name, String symbol, double value, double amount, String contractAddress, String peggedCurrency) {
        return new Stablecoin(name, symbol, value, amount, contractAddress, peggedCurrency);
    }

    public String getPeggedCurrency() {
        return peggedCurrency;
    }

    public void setPeggedCurrency(String peggedCurrency) {
        this.peggedCurrency = peggedCurrency;
    }
}
