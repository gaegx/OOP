package main.java.com.controller;

import main.java.com.model.CryptoAsset;
import main.java.com.model.User;
import main.java.com.view.SellFrame;
import main.java.com.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellController {
    private User user;
    private SellFrame sellFrame;
    private MainFrame mainFrame;

    public SellController(User user, SellFrame sellFrame, MainFrame mainFrame) {
        this.user = user;
        this.sellFrame = sellFrame;
        this.mainFrame = mainFrame;
        setupListeners();
    }

    private void setupListeners() {

        for (ActionListener al : sellFrame.getSellButton().getActionListeners()) {
            sellFrame.getSellButton().removeActionListener(al);
        }


//        sellFrame.getSellButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sellSelectedAsset();
//            }
//        });
    }


    public void sellSelectedAsset() {
        String selectedAsset = sellFrame.getSelectedAsset();
        String amountText = sellFrame.getAmount();

        if (amountText == null || amountText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(sellFrame, "Введите количество!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText.trim());
            if (amount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(sellFrame, "Некорректное количество!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CryptoAsset asset = user.getCryptoList().getAssetByName(selectedAsset);
        if (asset == null) {
            JOptionPane.showMessageDialog(sellFrame, "Выбранный актив не найден!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (asset.getAmount() < amount) {
            JOptionPane.showMessageDialog(sellFrame, "Недостаточно актива для продажи!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalRevenue = asset.getPrice() * amount;
        user.setBalance(user.getBalance() + totalRevenue);
        asset.decreaseAmount(amount);

        if (asset.getAmount() == 0) {
            user.getCryptoList().removeAsset(asset);
        }

        mainFrame.updateBalance(user);
        mainFrame.updateAssetsList();

        JOptionPane.showMessageDialog(sellFrame, "Актив успешно продан!\nТекущий баланс: " + user.getBalance() + "\nВыручка: " + totalRevenue, "Успех", JOptionPane.INFORMATION_MESSAGE);
        sellFrame.dispose();
    }
}
