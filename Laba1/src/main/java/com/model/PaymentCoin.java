package main.java.com.model;

public class PaymentCoin extends Coin {
    private double transactionSpeed; // Время подтверждения (в минутах)

    public PaymentCoin(String assetName, String symbol, String blockchain, double price, double transactionSpeed) {
        super(assetName, symbol, blockchain, price);
        this.transactionSpeed = transactionSpeed;
    }

    public double getTransactionSpeed() {
        return transactionSpeed;
    }


}
