package main.java.com.model.NFTs;

import main.java.com.model.NFT;

public class ArtNFT extends NFT {
    private String artistName;

    private ArtNFT(String name, String symbol, double value, String metadata, String artistName) {
        super(name, symbol, metadata, value);
        this.artistName = artistName;
    }

    public static ArtNFT createArtNFT(String name, String symbol, double value, String metadata, String artistName) {
        return new ArtNFT(name,symbol,value,metadata,artistName);
    }


}
