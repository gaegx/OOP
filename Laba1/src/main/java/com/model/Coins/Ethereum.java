package main.java.com.model.Coins;

import main.java.com.model.Coin;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Blockchain:", "Smart Contract Enabled?"})
public class Ethereum extends Coin {
    private boolean isSmartContractEnabled;

    public Ethereum(String name, String symbol, double value, double amount, String blockchain, boolean isSmartContractEnabled) {
        super(name, symbol, blockchain, value, amount);
        this.isSmartContractEnabled = isSmartContractEnabled;
    }


    public static Ethereum Create(String name, String symbol, double value, double amount, String blockchain, boolean isSmartContractEnabled) {
        return new Ethereum(name, symbol, value, amount, blockchain, isSmartContractEnabled);
    }

    public boolean isSmartContractEnabled() {
        return isSmartContractEnabled;
    }

    public void setSmartContractEnabled(boolean smartContractEnabled) {
        this.isSmartContractEnabled = smartContractEnabled;
    }
}
