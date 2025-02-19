package main.java.com.view;

import javax.swing.*;
import java.awt.*;

public class ReplenishFrame extends JFrame {
    ReplenishFrame() {
        setTitle("Crypto");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Создаем и настраиваем заголовок
        JLabel titleLabel = new JLabel("Пополнить");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));

        // Создаем метку и текстовое поле для номера счета
        JLabel nameLabel = new JLabel("Номер счета:");
        JTextField walletNumber = new JTextField(15);

        // Создаем выпадающий список для выбора актива
        String[] items = {"Bitcoin", "Ethereum", "ArtNFT", "GameNFT", "Stablecoin", "UtilityCoin"};
        JComboBox<String> assets = new JComboBox<>(items);


        JButton confirmButton = new JButton("Подтвердить");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Отступы между компонентами


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(walletNumber, gbc);

        // Размещаем выпадающий список
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(assets, gbc);

        // Размещаем кнопку "Подтвердить"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(confirmButton, gbc);

        // Делаем окно видимым
        setVisible(true);
    }

}