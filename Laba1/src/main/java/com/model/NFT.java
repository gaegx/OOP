package main.java.com.model;

public class NFT extends CryptoAsset {
    private String metadata;

    protected NFT(String assetName, String symbol, String metadata, double price,double amount) {
        super(assetName, symbol, price, amount);
        this.metadata = metadata;
    }

    public static NFT CreateNFT(String assetName, String symbol, String metadata, double price,double amount) {
        return new NFT(assetName, symbol, metadata, price,amount);
    }

    @Override
    public String gettype() {
        return "NFT";
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
