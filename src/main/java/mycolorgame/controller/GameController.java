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

        view.startButton.addActionListener(e -> {
            view.showGamePanel();
            logic.startTimer(view.timerLabel);
            logic.generateNewQuestion(view.answerButtons, view.questionLabel);
        });


        for (JButton button : view.answerButtons) {
            button.addActionListener(e -> {
                boolean correct = logic.checkAnswer(button);


                view.scoreLabel.setText("Scor: " + logic.getScore());


                logic.generateNewQuestion(view.answerButtons, view.questionLabel);
            });
        }
    }
}