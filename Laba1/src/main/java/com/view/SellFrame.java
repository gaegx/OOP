package main.java.com.view;

import main.java.com.controller.SellController;
import main.java.com.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellFrame extends JFrame {
    private User user;
    private JComboBox<String> assets;
    private JTextField amountField;
    private JButton sellButton;
    private JButton backButton;
    private JLabel availableAmountLabel;
    private SellController sellController;
    private MainFrame mainFrame;

    public SellFrame(User user, MainFrame mainFrame) {
        this.user = user;
        this.mainFrame = mainFrame;

        setTitle("Продажа актива");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Продать актив");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel assetLabel = new JLabel("Выберите актив:");
        String[] items = user.getCryptoList().getAssetNames().toArray(new String[0]);
        assets = new JComboBox<>(items);

        JLabel amountLabel = new JLabel("Количество:");
        amountField = new JTextField(15);


        availableAmountLabel = new JLabel("Доступно: " + getAvailableAmount());

        sellButton = createStyledButton("Продать");
        backButton = createStyledButton("Назад");

        this.sellController = new SellController(user, this, mainFrame);

        sellButton.addActionListener(e -> {
            sellController.sellSelectedAsset();
            this.setVisible(false);
            mainFrame.setVisible(true);
        });

        backButton.addActionListener(e -> {
            this.dispose();
            mainFrame.setVisible(true);
        });

        assets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAvailableAmount();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(assetLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(assets, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(availableAmountLabel, gbc);

        gbc.gridy = 4;
        add(sellButton, gbc);

        gbc.gridy = 5;
        add(backButton, gbc);

        setVisible(true);
    }

    public String getSelectedAsset() {
        return (String) assets.getSelectedItem();
    }

    public String getAmount() {
        return amountField.getText();
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

    public JButton getSellButton() {
        return sellButton;
    }

    private void updateAvailableAmount() {
        availableAmountLabel.setText("Доступно: " + getAvailableAmount());
    }

    private String getAvailableAmount() {
        String selectedAsset = getSelectedAsset();
        return String.valueOf(user.getCryptoList().getAssetAmount(selectedAsset));
    }
}
