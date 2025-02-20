package main.java.com.model.Coins;

import main.java.com.model.Coin;
import main.java.com.model.PaymentCoin;

public class Bitcoin extends PaymentCoin {
    private double maxSupply;

    private Bitcoin(String assetName, String symbol, String blockchain, double price,double amount,double transactionSpeed, double maxSupply) {
        super(assetName, symbol, blockchain, price,amount,transactionSpeed); // Вызов конструктора Coin
        this.maxSupply = maxSupply; // Инициализация поля maxSupply
    }

    public static Bitcoin createBitcoin(String assetName, String symbol, String blockchain, double price,double amount,double transactionSpeed, double maxSupply) {
        return new Bitcoin(assetName, symbol, blockchain, price,amount, transactionSpeed, maxSupply);
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(double maxSupply) {
        this.maxSupply = maxSupply;
    }
}
