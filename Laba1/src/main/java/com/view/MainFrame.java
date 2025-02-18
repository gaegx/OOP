package main.java.com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import main.java.com.view.RegFrame;


public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Crypto");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JLabel titleLabel = new JLabel("Crypto");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));

        JButton registerButton =createStyledButton("Register");
        JButton authenticateButton = createStyledButton("Authenticate");

        registerButton.addActionListener(this::Onreg);
        authenticateButton.addActionListener(this::Onaut);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(registerButton, gbc);

        gbc.gridy = 2;
        add(authenticateButton, gbc);

        setVisible(true);

    }
    private void Onreg(ActionEvent e) {
        new RegFrame();
        this.dispose();


    }

    private void Onaut(ActionEvent e) {

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
