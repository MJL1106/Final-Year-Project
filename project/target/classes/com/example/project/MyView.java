package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyView {

    private Player p1,p2;

    @FXML
    private TextField Choice1;

    @FXML
    private TextField Choice2;

    @FXML
    private TextField Name1;

    @FXML
    private TextField Name2;

    @FXML
    private Button compare;

    @FXML
    private Button names;

    @FXML
    private TextArea taOutput;

    @FXML
    void enterNames(ActionEvent event) {
        p1 = new Player(Name1.getText());
        p2 = new Player(Name2.getText());
    }

    @FXML
    void showJailTime(ActionEvent event) {
        p1.setChoice(Choice1.getText());
        p2.setChoice(Choice2.getText());
        Iterator.tallyPoints(p1,p2);
        taOutput.setText(p1.getPlayerName() + " points: " + p1.getJailTime() + "\n" + p2.getPlayerName() + " points: " + p2.getJailTime());
        Choice1.setText("");
        Choice2.setText("");

    }

}
