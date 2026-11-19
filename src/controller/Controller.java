package src.controller;

import javax.swing.JOptionPane;

import src.view.WeekdaysPanel;

public class Controller {

    WeekdaysPanel weekdaysPanel = new WeekdaysPanel();

    public Controller() {
        weekdaysPanel.getAddFoodButton().addActionListener(event -> {
            String food = JOptionPane.showInputDialog("Enter food you want to add for");
        });
    }
}
