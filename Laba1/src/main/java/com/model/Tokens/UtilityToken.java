package main.java.com.model.Tokens;

import main.java.com.model.Token;
import main.java.com.util.AssetFactory;
@AssetFactory(paramPrompts = {"Name:", "Symbol:", "Value:", "Amount:", "Contract Address:", "Use Case:"})
public class UtilityToken extends Token {
    private String useCase;

    private UtilityToken(String name, String symbol, double value, double amount, String contractAddress, String useCase) {
        super(name, symbol, contractAddress, value, amount);
        this.useCase = useCase;
    }


    public static UtilityToken Сreate(String name, String symbol, double value, double amount, String contractAddress, String useCase) {
        return new UtilityToken(name, symbol, value, amount, contractAddress, useCase);
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }
}
