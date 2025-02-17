package main.java.com.model;

public class NFT extends CryptoAsset {
    private String metadata;

    private NFT(String assetName, String symbol, String metadata, double price) {
        super(assetName, symbol, price);
        this.metadata = metadata;
    }

    public static NFT CreateNFT(String assetName, String symbol, String metadata, double price) {
        return new NFT(assetName, symbol, metadata, price);
    }
}
