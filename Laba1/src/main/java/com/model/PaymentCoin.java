package main.java.com.model;

public class PaymentCoin extends Coin {
    private double transactionSpeed;

    public PaymentCoin(String assetName, String symbol, String blockchain, double price,double amount, double transactionSpeed) {
        super(assetName, symbol, blockchain, price,amount);
        this.transactionSpeed = transactionSpeed;
    }

    public double getTransactionSpeed() {
        return transactionSpeed;
    }


    public void setTransactionSpeed(double transactionSpeed) {
        this.transactionSpeed = transactionSpeed;
    }

}
