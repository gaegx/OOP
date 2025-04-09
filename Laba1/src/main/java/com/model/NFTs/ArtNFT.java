package main.java.com.model.NFTs;

import main.java.com.model.NFT;
import main.java.com.util.AssetFactory;

public class ArtNFT extends NFT {
    private String artistName;

    private ArtNFT(String name, String symbol, double value, double amount, String metadata, String artistName) {
        super(name, symbol, metadata, value, amount);
        this.artistName = artistName;
    }

    @AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Metadata:", "Artist Name:"})
    public static ArtNFT createArtNFT(String name, String symbol, double value, double amount, String metadata, String artistName) {
        return new ArtNFT(name, symbol, value, amount, metadata, artistName);
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
