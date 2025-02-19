package main.java.com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CryptoList {
    private List<CryptoAsset> assets = new ArrayList<>();

    public int getSize() {
        return assets.size();
    }

    public void add(CryptoAsset asset) {
        assets.add(asset);
    }

    public CryptoAsset get(int index) {
        if (index >= 0 && index < assets.size()) {
            return assets.get(index);
        }
        return null; // Защита от выхода за границы списка
    }

    public CryptoAsset remove(int index) {
        if (index >= 0 && index < assets.size()) {
            return assets.remove(index);
        }
        return null; // Защита от выхода за границы списка
    }

    // Метод возвращает список всех активов
    public List<CryptoAsset> getAllAssets() {
        return new ArrayList<>(assets); // Возвращаем копию списка для безопасности
    }

    // Поиск активов по типу (возвращает новый CryptoList)
    public CryptoList findByType(String type) {
        CryptoList result = new CryptoList();
        for (CryptoAsset asset : assets) {
            if (asset.gettype().equalsIgnoreCase(type)) {
                result.add(asset);
            }
        }
        return result;
    }

    public CryptoAsset findByName(String name) {
        for (CryptoAsset asset : assets) {
            if (asset.getAssetName().equalsIgnoreCase(name)) {
                return asset;
            }
        }
        return null;
    }

    public CryptoAsset findBySymbol(String symbol) {
        for (CryptoAsset asset : assets) {
            if (asset.getsymbol().equalsIgnoreCase(symbol)) {
                return asset;
            }
        }
        return null;
    }

    public CryptoAsset findByValue(double value) {
        for (CryptoAsset asset : assets) {
            if (asset.getPrice() == value) {
                return asset;
            }
        }
        return null;
    }




    // Метод для вывода всех активов в строковом формате
    public String toString() {
        StringBuilder sb = new StringBuilder("CryptoList:\n");
        for (CryptoAsset asset : assets) {
            sb.append(asset.toString()).append("\n");
        }
        return sb.toString();
    }
}
