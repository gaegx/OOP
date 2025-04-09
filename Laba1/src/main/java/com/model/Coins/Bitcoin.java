package main.java.com.model.Coins;

import main.java.com.model.PaymentCoin;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Asset name:", "Symbol:", "Blockchain:", "Price:", "Amount:", "Transaction Speed:", "Max Supply:"})
public class Bitcoin extends PaymentCoin {
    private double maxSupply;

    private Bitcoin(String assetName, String symbol, String blockchain, double price, double amount, double transactionSpeed, double maxSupply) {
        super(assetName, symbol, blockchain, price, amount, transactionSpeed);
        this.maxSupply = maxSupply;
    }


    public static Bitcoin Create(String assetName, String symbol, String blockchain, double price, double amount, double transactionSpeed, double maxSupply) {
        return new Bitcoin(assetName, symbol, blockchain, price, amount, transactionSpeed, maxSupply);
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(double maxSupply) {
        this.maxSupply = maxSupply;
    }




}
