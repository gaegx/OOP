package main.java.com.model;

public class Coin extends CryptoAsset {
    private String blockchain;
     private Coin(String assetName, String symbol, String blockchain, double price) {
         super(assetName, symbol, price);
         this.blockchain = blockchain;
     }

     public static Coin CreateCoin(String assetName, String symbol, String blockchain, double price) {
         return new Coin(assetName, symbol, blockchain, price);
     }

}
