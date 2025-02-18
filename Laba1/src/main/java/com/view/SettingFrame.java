package main.java.com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingFrame extends JFrame  {

    public SettingFrame() {
        setTitle("Crypto");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));
        JButton deleteButton = createStyledButton("Удалить аккаунт");
        JButton exitButton = createStyledButton("Выйти из аккаунта");
        JButton backButton = createStyledButton("Назад");

        deleteButton.addActionListener(this::Delete);
        exitButton.addActionListener(this::Exit);
        backButton.addActionListener(this::Back);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(exitButton, gbc);

        gbc.gridy = 2;
        add(deleteButton, gbc);

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
    private void Delete(ActionEvent e) {
        //Логику удаление прописать
        new StartFrame();
        this.dispose();
    }

    private void Exit(ActionEvent e) {
        new StartFrame();
        this.dispose();
    }

    private void Back(ActionEvent e) {

    }


}
