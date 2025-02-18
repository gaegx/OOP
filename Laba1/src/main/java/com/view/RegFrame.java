package main.java.com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class RegFrame extends JFrame {
    public RegFrame() {
        setTitle("Crypto");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel nameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JLabel emailLabel= new JLabel("Email");

        JTextField nameField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JButton registerButton = new JButton("Зарегистрироваться");
        registerButton.addActionListener(this::OnMain);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

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
        add(registerButton, gbc);

        setVisible(true);

    }

    private void OnMain(ActionEvent e) {
        this.dispose();

    }
}
