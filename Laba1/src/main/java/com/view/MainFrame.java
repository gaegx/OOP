package main.java.com.view;

import main.java.com.model.CryptoAsset;
import main.java.com.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainFrame extends JFrame {
    private User user;
    private JLabel balanceLabel;
    private DefaultListModel<String> assetsModel;
    private JList<String> assetsList;

    public MainFrame(User user) {
        this.user = user;
        setTitle("Криптокошелек");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel welcomeLabel = new JLabel("Добро пожаловать, " + user.getUsername() + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Баланс пользователя
        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Инициализация assetsModel перед его использованием
        assetsModel = new DefaultListModel<>();
        assetsList = new JList<>(assetsModel);
        assetsList.setFont(new Font("Arial", Font.PLAIN, 14));
        assetsList.setVisibleRowCount(5);
        assetsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(assetsList);
        scrollPane.setPreferredSize(new Dimension(250, 100));

        updateBalance(); // Устанавливаем текущий баланс и заполняем список активов

        JButton depositButton = createStyledButton("➕ Пополнить", e -> openFrame(new AddassetFrame()));
        JButton transferButton = createStyledButton("📤 Перевести", e -> openFrame(new ReplenishFrame()));
        JButton historyButton = createStyledButton("📜 История", e -> openFrame(new HistoryFrame()));
        JButton settingsButton = createStyledButton("⚙️ Настройки", e -> openFrame(new SettingFrame()));
        JButton logoutButton = createStyledButton("Выйти", e -> System.exit(0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(welcomeLabel, gbc);

        gbc.gridy = 1;
        add(balanceLabel, gbc); // Баланс

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(scrollPane, gbc); // Активы

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(depositButton, gbc);

        gbc.gridx = 1;
        add(transferButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(historyButton, gbc);

        gbc.gridx = 1;
        add(settingsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(logoutButton, gbc);

        setVisible(true);
    }


    private JButton createStyledButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(126, 153, 119));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.addActionListener(action);
        return button;
    }

    private void openFrame(JFrame frame) {
        frame.setVisible(true);
        dispose(); // Закрываем текущее окно, чтобы не нагружать память
    }

    public void updateBalance() {
        balanceLabel.setText("Баланс: $" + user.getBalance());
        updateAssetsList(); // Обновляем список активов
    }

    private void updateAssetsList() {
        assetsModel.clear();
        List<CryptoAsset> assets = user.getCryptoList().getAllAssets(); // Получаем список активов
        for (CryptoAsset asset : assets) {
            assetsModel.addElement(asset.getAssetName() + " (" + asset.getsymbol() + "): $" + asset.getPrice());
        }
    }
}
