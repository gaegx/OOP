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
import java.lang.reflect.Method;

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
        try {
            String className = switch (type) {
                case "Bitcoin" -> "main.java.com.model.Coins.Bitcoin";
                case "Ethereum" -> "main.java.com.model.Coins.Ethereum";
                case "ArtNFT" -> "main.java.com.model.NFT.ArtNFT";
                case "GameNFT" -> "main.java.com.model.NFT.GameNFT";
                case "Stablecoin" -> "main.java.com.model.Stablecoins.Stablecoin";
                case "UtilityCoin" -> "main.java.com.model.Utility.UtilityToken";
                default -> throw new IllegalArgumentException("Неизвестный тип актива: " + type);
            };

            Class<?> clazz = Class.forName(className);
            String methodName = switch (type) {
                case "Bitcoin" -> "createBitcoin";
                case "Ethereum" -> "createEthereum";
                case "ArtNFT" -> "createArtNFT";
                case "GameNFT" -> "createGameNFT";
                case "Stablecoin" -> "createStablecoin";
                case "UtilityCoin" -> "createUtilityToken";
                default -> throw new IllegalArgumentException("Неизвестный метод");
            };

            Method factoryMethod;
            Object[] args;

            switch (type) {
                case "Bitcoin" -> {
                    String assetName = JOptionPane.showInputDialog("Asset name:");
                    String symbol = JOptionPane.showInputDialog("Symbol:");
                    String blockchain = JOptionPane.showInputDialog("Blockchain:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                    double transactionSpeed = Double.parseDouble(JOptionPane.showInputDialog("Transaction Speed:"));
                    double maxSupply = Double.parseDouble(JOptionPane.showInputDialog("Max Supply:"));

                    factoryMethod = clazz.getMethod(methodName,
                            String.class, String.class, String.class,
                            double.class, double.class, double.class, double.class);

                    args = new Object[]{assetName, symbol, blockchain, price, amount, transactionSpeed, maxSupply};
                }
                case "Ethereum" -> {
                    String assetName = JOptionPane.showInputDialog("Asset name:");
                    String symbol = JOptionPane.showInputDialog("Symbol:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                    String blockchain = JOptionPane.showInputDialog("Blockchain:");
                    boolean staking = JOptionPane.showConfirmDialog(null, "Поддерживает стейкинг?", "Staking",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                    factoryMethod = clazz.getMethod(methodName,
                            String.class, String.class,
                            double.class, double.class,
                            String.class, boolean.class);

                    args = new Object[]{assetName, symbol, price, amount, blockchain, staking};
                }
                case "ArtNFT", "GameNFT" -> {
                    String assetName = JOptionPane.showInputDialog("Asset name:");
                    String symbol = JOptionPane.showInputDialog("Symbol:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                    String metadata = JOptionPane.showInputDialog("Metadata:");
                    String authorOrGame = JOptionPane.showInputDialog(
                            type.equals("ArtNFT") ? "Author:" : "Game:");

                    factoryMethod = clazz.getMethod(methodName,
                            String.class, String.class, double.class, double.class,
                            String.class, String.class);

                    args = new Object[]{assetName, symbol, price, amount, metadata, authorOrGame};
                }
                case "Stablecoin", "UtilityCoin" -> {
                    String assetName = JOptionPane.showInputDialog("Asset name:");
                    String symbol = JOptionPane.showInputDialog("Symbol:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
                    String contract = JOptionPane.showInputDialog("Contract address:");
                    String backingOrUtility = JOptionPane.showInputDialog(
                            type.equals("Stablecoin") ? "Fiat backing:" : "Utility purpose:");

                    factoryMethod = clazz.getMethod(methodName,
                            String.class, String.class, double.class, double.class,
                            String.class, String.class);

                    args = new Object[]{assetName, symbol, price, amount, contract, backingOrUtility};
                }
                default -> throw new IllegalArgumentException("Неподдерживаемый тип: " + type);
            }

            return (CryptoAsset) factoryMethod.invoke(null, args);

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании актива: " + e.getMessage(), e);
        }
    }
}

