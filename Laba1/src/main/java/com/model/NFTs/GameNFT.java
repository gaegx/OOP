package main.java.com.model.NFTs;

import main.java.com.model.NFT;


public class GameNFT extends NFT {
    private String gameName;

    private GameNFT(String name, String symbol, double value, String metadata, String gameName) {
        super(name, symbol, metadata, value);
        this.gameName = gameName;
    }

    public static GameNFT createGameNFT(String name, String symbol, double value, String metadata, String gameName) {
        return new GameNFT(name,symbol,value,metadata,gameName);
    }

}