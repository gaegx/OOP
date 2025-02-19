package main.java.com.view;

import javax.swing.*;
import java.awt.*;

public class AddassetFrame extends JFrame {
    public AddassetFrame() {
        setTitle("Crypto");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Заголовок
        JLabel titleLabel = new JLabel("Пополнить");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));

        // Выпадающий список для выбора актива
        String[] items = {"Bitcoin", "Ethereum", "ArtNFT", "GameNFT", "Stablecoin", "UtilityCoin"};
        JComboBox<String> assets = new JComboBox<>(items);

        // Метка и текстовое поле для ввода количества
        JLabel nameLabel = new JLabel("Количество:");
        JTextField amountField = new JTextField(15);

        // Кнопка подтверждения
        JButton confirmButton = createStyledButton("Подтвердить");

        // Настройка GridBagConstraints для расположения компонентов
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Отступы между компонентами
        gbc.fill = GridBagConstraints.HORIZONTAL; // Растягивание компонентов по горизонтали

        // Размещение заголовка
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Заголовок занимает две колонки
        gbc.anchor = GridBagConstraints.CENTER; // Выравнивание по центру
        add(titleLabel, gbc);

        // Размещение выпадающего списка
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(assets, gbc);

        // Размещение метки "Количество"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END; // Выравнивание по правому краю
        add(nameLabel, gbc);

        // Размещение текстового поля для ввода количества
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START; // Выравнивание по левому краю
        add(amountField, gbc);

        // Размещение кнопки "Подтвердить"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(confirmButton, gbc);

        // Делаем окно видимым
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(200, 40)); // Увеличиваем размер кнопки
        button.setBackground(new Color(126, 153, 119));  // Цвет фона (синий)
        button.setForeground(Color.WHITE);              // Цвет текста (белый)
        button.setFocusPainted(false);                 // Убираем границу фокуса
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Убираем стандартные границы
        return button;
    }


}
