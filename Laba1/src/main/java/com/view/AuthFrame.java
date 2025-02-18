package main.java.com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AuthFrame extends JFrame {
    private String username;
    private String password;


    public AuthFrame() {
        setTitle("Crypto");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JLabel emailLabel= new JLabel("Email");
        JLabel passwordLabel = new JLabel("Password");

        JTextField emailField = new JTextField(20);
        JTextField passwordField = new JTextField(20);

        JButton authButton = createStyledButton("Авторизоваться");
        authButton.addActionListener(this::OnMain);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        gbc.gridx = 0; gbc.gridy = 1;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(authButton, gbc);

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

    private void OnMain(ActionEvent e) {
        new MainFrame(username);
        this.dispose();

    }
}
