package main.java.com.view;

import main.java.com.model.*;
import main.java.com.model.Coins.Bitcoin;
import main.java.com.model.Coins.Ethereum;
import main.java.com.model.NFTs.ArtNFT;
import main.java.com.model.NFTs.GameNFT;
import main.java.com.model.Tokens.Stablecoin;
import main.java.com.model.Tokens.UtilityToken;

import javax.swing.*;
import java.awt.*;
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

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        assetsModel = new DefaultListModel<>();
        assetsList = new JList<>(assetsModel);
        assetsList.setFont(new Font("Arial", Font.PLAIN, 14));
        assetsList.setVisibleRowCount(5);
        assetsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(assetsList);
        scrollPane.setPreferredSize(new Dimension(350, 150));

        updateBalance(user);

        JButton depositButton = createStyledButton("➕ Пополнить", e -> openFrame(new AddassetFrame(this, user)));
        JButton transferButton = createStyledButton("📤 Продать", e -> {openFrame(new SellFrame(user,this));});
        JButton logoutButton = createStyledButton("Выйти", e -> System.exit(0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(welcomeLabel, gbc);

        gbc.gridy = 1;
        add(balanceLabel, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(scrollPane, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(depositButton, gbc);

        gbc.gridx = 1;
        add(transferButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
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
        dispose();
    }

    public void updateBalance(User user) {
        balanceLabel.setText("Баланс: $" + user.getBalance());
        updateAssetsList();
    }

    public void updateAssetsList() {
        assetsModel.clear();
        List<CryptoAsset> assets = user.getCryptoList().getAllAssets();
        for (CryptoAsset asset : assets) {
            String assetInfo = String.format("%s (%s) - Количество: %.2f | Цена: $%.2f | Общая стоимость: $%.2f",
                    asset.getAssetName(), asset.getsymbol(), asset.getAmount(), asset.getPrice(), asset.getAmount() * asset.getPrice());

            if (asset instanceof Coin) {
                Coin coin = (Coin) asset;
                assetInfo += String.format(" | Блокчейн: %s", coin.getBlockchain());
            }
            if (asset instanceof PaymentCoin) {
                PaymentCoin paymentCoin = (PaymentCoin) asset;
                assetInfo += String.format(" | Скорость транзакций: %.2f", paymentCoin.getTransactionSpeed());
            }
            if (asset instanceof Bitcoin) {
                Bitcoin bitcoin = (Bitcoin) asset;
                assetInfo += String.format(" | Макс. эмиссия: %.2f", bitcoin.getMaxSupply());
            }

            if (asset instanceof Token) {
                Token token = (Token) asset;
                assetInfo += String.format(" | Контракт: %s", token.getContractAddress());
            }
            if (asset instanceof Stablecoin) {
                Stablecoin stablecoin = (Stablecoin) asset;
                assetInfo += String.format(" | Привязан к: %s", stablecoin.getPeggedCurrency());
            }
            if (asset instanceof UtilityToken) {
                UtilityToken utilityToken = (UtilityToken) asset;
                assetInfo += String.format(" | Применение: %s", utilityToken.getUseCase());
            }
            if (asset instanceof NFT) {
                NFT nft = (NFT) asset;
                assetInfo += String.format(" | Метаданные: %s", nft.getMetadata());
            }
            if (asset instanceof GameNFT) {
                GameNFT gameNFT = (GameNFT) asset;
                assetInfo += String.format(" | Игра: %s", gameNFT.getGameName());
            }
            if (asset instanceof ArtNFT) {
                ArtNFT artNFT = (ArtNFT) asset;
                assetInfo += String.format(" | Художник: %s", artNFT.getArtistName());
            }

            assetsModel.addElement(assetInfo);
        }
    }



}
