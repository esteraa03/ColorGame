package mycolorgame.ui;

import mycolorgame.ui.MainView;
import mycolorgame.controller.GameController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public JButton startButton = new JButton("Start Game");
    public JLabel timerLabel = new JLabel("Timp: 30");
    public JLabel scoreLabel = new JLabel("Scor: 0");
    public JLabel questionLabel = new JLabel("Întrebare");

    public JButton[] answerButtons = new JButton[4];
    public JPanel gamePanel = new JPanel();

    ImageIcon logo = new ImageIcon("C:\\Users\\ester\\IdeaProjects\\ColorGame\\src\\main\\resources\\logo.jpg");

    public MainView() {
        this.setTitle("My Color Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);

        setupStartPanel();
        setupGamePanel();
    }

    private void setupStartPanel() {
        JPanel startPanel = new JPanel(new BorderLayout());
        startPanel.setBackground(new Color(77, 153, 153));

        JLabel title = new JLabel("My Color Game", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        startPanel.add(title, BorderLayout.CENTER);
        startPanel.add(startButton, BorderLayout.SOUTH);

        this.add(startPanel, BorderLayout.CENTER);
    }

    private void setupGamePanel() {
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(Color.WHITE);


        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(timerLabel);
        topPanel.add(scoreLabel);


        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);



        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            buttonPanel.add(answerButtons[i]);
        }

        gamePanel.add(topPanel, BorderLayout.NORTH);
        gamePanel.add(questionLabel, BorderLayout.CENTER);
        gamePanel.add(buttonPanel, BorderLayout.SOUTH);

    }

    public void showGamePanel() {
        this.getContentPane().removeAll();
        this.add(gamePanel);
        this.revalidate();
        this.repaint();
    }


}
