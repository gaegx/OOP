package main.java.com.model.Tokens;

import main.java.com.model.Token;

public class UtilityToken extends Token {
    private String useCase;

    private UtilityToken(String name, String symbol, double value, String contractAddress, String useCase) {
        super(name, symbol, contractAddress, value);
        this.useCase = useCase;
    }

    public static UtilityToken createUtilityToken(String name, String symbol, double value, String contractAddress, String useCase) {
        return new UtilityToken(name,symbol,value,contractAddress,useCase);
    }


}
