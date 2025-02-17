package main.java.com.model;



public class Token extends CryptoAsset {
    private String contractAddress;

    private Token(String assetName, String symbol,String contractAddress, double price) {
        super(assetName, symbol, price);
        this.contractAddress=contractAddress;
    }

    public static Token CreateToken(String assetName, String symbol,String contractAddress, double price) {
        return new Token(assetName, symbol,contractAddress, price);
    }

}


