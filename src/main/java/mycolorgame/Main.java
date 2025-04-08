package mycolorgame;

import mycolorgame.ui.MainView;
import mycolorgame.controller.GameController;

import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            MainView mainView = new MainView();
            new GameController(mainView);
            mainView.setVisible(true);
        });
    }
}