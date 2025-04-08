// model/GameLogic.java
package mycolorgame.logic;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import javax.swing.Timer;

public class GameLogic {
    private int timeLeft = 30;
    private int score = 0;
    private Timer timer;
    private Color correctAnswer;

    // Definirea culorilor disponibile
    private final String[] colorNames = {"Red", "Blue", "Green", "Yellow"};


    // Modificarea metodei startTimer
    public void startTimer(JLabel timerLabel) {
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Timp: " + timeLeft);
            if (timeLeft <= 0) {
                timer.stop();
                // Logica pentru oprirea jocului
                JOptionPane.showMessageDialog(null, "Time is over! Your score: " + score);
            }
        });
        timer.start();
    }

    public void generateNewQuestion(JButton[] answerButtons, JLabel questionLabel) {
        // Lista de culori disponibile și numele lor
        Color[] colors = {
                new Color(255, 0, 0),     // Roșu
                new Color(0, 0, 255),     // Albastru
                new Color(0, 128, 0),     // Verde
                new Color(255, 255, 0),   // Galben
                new Color(255, 105, 180), // Roz
                new Color(128, 0, 128),   // Mov
                new Color(255, 165, 0),   // Portocaliu
                new Color(0, 255, 255)    // Turcoaz
        };

        String[] colorNames = {
                "Red", "Blue", "Green", "Yellow",
                "Pink", "Purple", "Orange", "Cyan"
        };

        // Alegem un răspuns corect random
        int correctIndex = (int)(Math.random() * colors.length);
        Color correctColor = colors[correctIndex];
        correctAnswer = colors[correctIndex];

        // Setăm întrebarea (colorăm și textul)
        questionLabel.setText(colorNames[correctIndex]);
        questionLabel.setForeground(correctColor);

        // Alegem un buton random care va avea culoarea corectă
        int correctButtonIndex = (int)(Math.random() * answerButtons.length);

        // Lista de indexuri greșite pentru texte
        List<Integer> wrongIndices = new ArrayList<>();
        for (int i = 0; i < colorNames.length; i++) {
            if (i != correctIndex) wrongIndices.add(i);
        }
        Collections.shuffle(wrongIndices);

        for (int i = 0; i < answerButtons.length; i++) {
            JButton button = answerButtons[i];

            if (i == correctButtonIndex) {
                // Butonul corect - culoarea e corectă, textul e greșit
                button.setBackground(correctColor);
                button.setOpaque(true);
                button.setBorderPainted(false);

                // Alegem un text greșit aleator
                String wrongText = colorNames[wrongIndices.get(0)];
                button.setText(wrongText);
            } else {
                // Culoare aleatoare greșită
                int randWrongColorIndex = wrongIndices.remove(0);
                button.setBackground(colors[randWrongColorIndex]);
                button.setOpaque(true);
                button.setBorderPainted(false);

                // Textul e alt nume greșit (random din cele greșite)
                String randomWrongText = colorNames[wrongIndices.get(0)];
                button.setText(randomWrongText);
            }
        }
    }


    public boolean checkAnswer(JButton selectedButton) {
        // Obținem culoarea butonului selectat
        Color selectedColor = selectedButton.getBackground();

        // Verificăm dacă culoarea butonului selectat este culoarea corectă
        if (selectedColor.equals(correctAnswer)) {
            score++;
            return true;
        }
        return false;
    }


    public int getScore() {
        return score;
    }


}


