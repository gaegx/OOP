package main.java.com.model;

import java.util.ArrayList;
import java.util.List;

public class CryptoList {
    private List<CryptoAsset> assets =new ArrayList<>();
    private static int  size;

    public int getSize() {
        return size;
    }

    public void add(CryptoAsset asset) {
        assets.add(asset);
        size++;
    }

    public CryptoAsset get(int index) {
        return assets.get(index);
    }

    public CryptoAsset remove(int index) {
        return assets.remove(index);
    }


    public CryptoAsset findbytype(String type) {
        for (CryptoAsset asset : assets) {
            if (asset.gettype().equals(type)) {
                return asset;
            }
        }
        return null;
    }

    public CryptoAsset findbyname(String name) {
        for (CryptoAsset asset : assets) {
            if(asset.getassetname().equals(name)) {
                return asset;
            }
        }
        return null;
    }

    public CryptoAsset findbysymbol(String symbol) {
        for (CryptoAsset asset : assets) {
            if(asset.getsymbol().equals(symbol)) {
                return asset;
            }
        }
        return null;
    }

    public CryptoAsset findbyvalue(double value) {
        for (CryptoAsset asset : assets) {
            if(asset.getprice() == value) {
                return asset;
            }
        }
        return null;
    }












}
