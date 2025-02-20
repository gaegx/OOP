package main.java.com.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CryptoList {
    private List<CryptoAsset> assets = new ArrayList<>();

    public int getSize() {
        return assets.size();
    }

    public void addAsset(CryptoAsset asset) {
        assets.add(asset);
    }

    public CryptoAsset get(int index) {
        if (index >= 0 && index < assets.size()) {
            return assets.get(index);
        }
        return null;
    }

    public CryptoAsset remove(int index) {
        if (index >= 0 && index < assets.size()) {
            return assets.remove(index);
        }
        return null;
    }

    public boolean removeByName(String name) {
        return assets.removeIf(asset -> asset.getAssetName().equalsIgnoreCase(name));
    }

    public void removeAsset(CryptoAsset asset) {
        assets.remove(asset);
    }

    public List<CryptoAsset> getAllAssets() {
        return new ArrayList<>(assets);
    }

    public List<String> getAssetsAsStrings() {
        List<String> assetStrings = new ArrayList<>();
        for (CryptoAsset asset : assets) {
            assetStrings.add(asset.toString());
        }
        return assetStrings;
    }

    public List<String> getAssetNames() {
        List<String> names = new ArrayList<>();
        for (CryptoAsset asset : assets) {
            names.add(asset.getAssetName());
        }
        return names;
    }

    public double getAssetAmount(String assetName) {
        CryptoAsset asset = getAssetByName(assetName);
        return (asset != null) ? asset.getAmount() : 0;
    }


    public CryptoList findByType(String type) {
        CryptoList result = new CryptoList();
        for (CryptoAsset asset : assets) {
            if (asset.gettype().equalsIgnoreCase(type)) {
                result.addAsset(asset);
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

    public CryptoAsset getAssetByName(String name) {
        return findByName(name);
    }

    @Override
    public String toString() {
        if (assets.isEmpty()) {
            return "Криптопортфель пуст.";
        }

        StringBuilder sb = new StringBuilder("Криптопортфель:\n");
        for (CryptoAsset asset : assets) {
            sb.append("• ").append(asset.toString()).append("\n");
        }
        return sb.toString();
    }
}


