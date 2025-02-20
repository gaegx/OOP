package main.java.com.controller;

import main.java.com.model.*;
import main.java.com.model.Coins.*;
import main.java.com.model.NFTs.*;
import main.java.com.model.Tokens.*;
import main.java.com.view.AddassetFrame;
import main.java.com.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class AssetController {
    private User user;
    private AddassetFrame assetFrame;
    private MainFrame mainFrame; // Добавляем ссылку на главное окно

    public AssetController(User user, AddassetFrame assetFrame, MainFrame mainFrame) {
        this.user = user;
        this.assetFrame = assetFrame;
        this.mainFrame = mainFrame; // Сохраняем переданное главное окно
        setupListeners();
    }

    private void setupListeners() {
        assetFrame.getConfirmButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSelectedAsset();
            }
        });
    }

    private void addSelectedAsset() {
        String selectedAsset = (String) assetFrame.getAssetComboBox().getSelectedItem();
        String amountText = assetFrame.getAmountField().getText();

        if (amountText == null || amountText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(assetFrame, "Введите количество!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText.trim());
            if (amount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(assetFrame, "Некорректное количество!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CryptoAsset asset = createAsset(selectedAsset, amount);
        if (asset != null) {
            double totalCost = asset.getPrice() * amount;
            if (user.getBalance() >= totalCost) {
                user.setBalance(user.getBalance() - totalCost);
                user.getCryptoList().addAsset(asset);
                mainFrame.updateBalance(user);




                JOptionPane.showMessageDialog(assetFrame, "Актив добавлен!\nТекущий баланс: " + user.getBalance() + "\nСтоимость покупки: " + totalCost, "Успех", JOptionPane.INFORMATION_MESSAGE);
                if (mainFrame != null) {
                    mainFrame.updateAssetsList();
                    mainFrame.setVisible(true);

                }
                assetFrame.dispose(); // Закрываем окно после добавления
            } else {
                JOptionPane.showMessageDialog(assetFrame, "Недостаточно средств!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(assetFrame, "Ошибка при добавлении актива!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static CryptoAsset createAsset(String type, double amount) {
        switch (type) {
            case "Bitcoin":
                return Bitcoin.createBitcoin("Bitcoin", "BTC", "Bitcoin", 50000.0, amount, 5.0, 21000000);
            case "Ethereum":
                return Ethereum.createEthereum("Ethereum", "ETH", 3000.0, amount, "Ethereum", true);
            case "ArtNFT":
                return ArtNFT.createArtNFT("Art NFT", "ART", 1500.0, amount, "metadata_art", "Famous Artist");
            case "GameNFT":
                return GameNFT.createGameNFT("Game NFT", "GNFT", 1200.0, amount, "metadata_game", "Cool Game");
            case "Stablecoin":
                return Stablecoin.createStablecoin("Stablecoin", "USDT", 1.0, amount, "contract_address", "USD");
            case "UtilityCoin":
                return UtilityToken.createUtilityToken("Utility Coin", "UTIL", 10.0, amount, "contract_address", "Payment");
            default:
                throw new IllegalArgumentException("Неизвестный тип актива: " + type);
        }
    }
}

