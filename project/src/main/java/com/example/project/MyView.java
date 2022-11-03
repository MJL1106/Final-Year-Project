package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyView {

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
    private TextArea taOutput;

    @FXML
    void showJailTime(ActionEvent event) {
        Player p1 = new Player(Name1.getText());
        Player p2 = new Player(Name2.getText());
        p1.setChoice(Choice1.getText());
        p2.setChoice(Choice2.getText());

    }

}
