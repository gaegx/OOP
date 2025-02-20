package main.java.com.model;

public class Coin extends CryptoAsset {
    private String blockchain;
     protected Coin(String assetName, String symbol, String blockchain, double price,double amount) {
         super(assetName, symbol, price,amount);
         this.blockchain = blockchain;
     }

     public static Coin CreateCoin(String assetName, String symbol, String blockchain, double price,double amount) {
         return new Coin(assetName, symbol, blockchain, price,amount);
     }

    @Override
    public String gettype() {
        return "Coin";
    }
    public String getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(String blockchain) {
        this.blockchain = blockchain;
    }


}
