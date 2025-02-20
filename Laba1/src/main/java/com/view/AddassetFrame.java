package main.java.com.view;

import main.java.com.controller.AssetController;
import main.java.com.model.User;

import javax.swing.*;
import java.awt.*;

public class AddassetFrame extends JFrame {
    private JComboBox<String> assets;
    private JTextField amountField;
    private JButton confirmButton;
    private JButton backButton;
    private MainFrame mainFrame;
    private User user;

    public AddassetFrame(MainFrame mainFrame, User user) {
        this.mainFrame = mainFrame;
        this.user = user;

        setTitle("Пополнить");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Пополнить");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));

        String[] items = {"Bitcoin", "Ethereum", "ArtNFT", "GameNFT", "Stablecoin", "UtilityCoin"};
        assets = new JComboBox<>(items);

        JLabel nameLabel = new JLabel("Количество:");
        amountField = new JTextField(15);

        confirmButton = createStyledButton("Подтвердить");
        backButton = createStyledButton("Назад");
        backButton.addActionListener(e -> goBack());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(assets, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(confirmButton, gbc);

        gbc.gridy = 4;
        add(backButton, gbc);

        new AssetController(user, this,mainFrame);

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(126, 153, 119));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    private void goBack() {
        mainFrame.setVisible(true);
        dispose();
    }

    public JComboBox<String> getAssetComboBox() {
        return assets;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
}
