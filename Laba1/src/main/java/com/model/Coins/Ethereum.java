package main.java.com.model.Coins;

import main.java.com.model.Coin;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Blockchain:"})
public class Ethereum extends Coin {


    public Ethereum(String name, String symbol, double value, double amount, String blockchain) {
        super(name, symbol, blockchain, value, amount);

    }


    public static Ethereum Create(String name, String symbol, double value, double amount, String blockchain) {
        return new Ethereum(name, symbol, value, amount, blockchain);
    }




}
