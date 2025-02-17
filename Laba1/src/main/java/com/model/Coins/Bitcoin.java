package main.java.com.model.Coins;

import main.java.com.model.Coin;

public class Bitcoin extends Coin {
    private double maxSupply;

    private Bitcoin(String assetName, String symbol, String blockchain, double price, double maxSupply) {
        super(assetName, symbol, blockchain, price); // Вызов конструктора Coin
        this.maxSupply = maxSupply; // Инициализация поля maxSupply
    }

    public static Bitcoin createBitcoin(String assetName, String symbol, String blockchain, double price, double maxSupply) {
        return new Bitcoin(assetName, symbol, blockchain, price, maxSupply);
    }

}
