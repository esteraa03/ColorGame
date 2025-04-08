package mycolorgame.controller;

import mycolorgame.ui.MainView;
import mycolorgame.logic.GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private final GameLogic logic;
    private final MainView view;

    public GameController(MainView view) {
        this.view = view;
        this.logic = new GameLogic();
        addListeners();
    }

    private void addListeners() {
        // Butonul de start
        view.startButton.addActionListener(e -> {
            view.showGamePanel();
            logic.startTimer(view.timerLabel);  // Startăm timerul
            logic.generateNewQuestion(view.answerButtons, view.questionLabel);  // Generăm o întrebare
        });

        // Ascultăm acțiunile pe butoane
        for (JButton button : view.answerButtons) {
            button.addActionListener(e -> {
                boolean correct = logic.checkAnswer(button);

                // Actualizează scorul în interfața utilizatorului
                view.scoreLabel.setText("Scor: " + logic.getScore());

                // Generăm o nouă întrebare după fiecare răspuns
                logic.generateNewQuestion(view.answerButtons, view.questionLabel);
            });
        }
    }
}