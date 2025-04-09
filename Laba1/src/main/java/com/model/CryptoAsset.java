package main.java.com.model;

public abstract class CryptoAsset {
    private String assetName;
    private String symbol;
    private double price;
    private double amount;

    public CryptoAsset(String assetName, String symbol, double price, double amount) {
        this.assetName = assetName;
        this.symbol = symbol;
        this.price = price;
        this.amount = amount;
    }

    public String getAssetName() {
        return assetName;
    }

    abstract String gettype();

    public String getassetname(){
        return assetName;
    }

    public String getsymbol(){
        return symbol;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double amount) {
        this.price = amount;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getAmount() {
        return amount;
    }

    public void decreaseAmount(double amount) {
        if (amount > 0 && this.amount >= amount) {
            this.amount -= amount;
        } else {
            throw new IllegalArgumentException("Недостаточно актива для списания или некорректное количество");
        }
    }
}
