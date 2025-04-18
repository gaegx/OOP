package main.java.com.model.NFTs;

import main.java.com.model.NFT;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Metadata:", "Game Name:"})
public class GameNFT extends NFT {
    private String gameName;

    private GameNFT(String name, String symbol, double value, double amount, String metadata, String gameName) {
        super(name, symbol, metadata, value, amount);
        this.gameName = gameName;
    }


    public static GameNFT Create(String name, String symbol, double value, double amount, String metadata, String gameName) {
        return new GameNFT(name, symbol, value, amount, metadata, gameName);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
