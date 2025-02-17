package main.java.com.model;

public abstract class CryptoAsset {
    private String assetName;
    private String symbol;
    private double price;

    public CryptoAsset(String assetName, String symbol, double price) {
        this.assetName = assetName;
        this.symbol = symbol;
        this.price = price;
    }



}
