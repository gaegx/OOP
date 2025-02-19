package main.java.com.view;

import main.java.com.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private String username;
    private User user;

    public MainFrame(String username) {
        setTitle("Криптокошелек");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("Добро пожаловать, " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton depositButton = createStyledButton("➕ Пополнить");
        JButton transferButton = createStyledButton("📤 Перевести");
        JButton historyButton = createStyledButton("📜 История");
        JButton settingsButton = createStyledButton("⚙️ Настройки");
        JButton logoutButton = createStyledButton("Выйти");

        settingsButton.addActionListener(this::OnSeting);
        transferButton.addActionListener(this::OnReplenish);
        logoutButton.addActionListener(e -> System.exit(0));
        depositButton.addActionListener(this::OnAdd);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(welcomeLabel, gbc);

//        gbc.gridy = 1;
//        add(balancePanel, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(depositButton, gbc);

        gbc.gridx = 1;
        add(transferButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(historyButton, gbc);

        gbc.gridx = 1;
        add(settingsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(logoutButton, gbc);

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

    private void OnSeting(ActionEvent e) {
        new SettingFrame();
        this.dispose();
    }

    private void OnReplenish(ActionEvent e) {
        new ReplenishFrame();
        this.setVisible(false);
    }

    private void OnAdd(ActionEvent e) {
        new AddassetFrame();
        this.setVisible(false);
    }
}
