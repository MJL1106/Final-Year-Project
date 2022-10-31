package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyView {

    @FXML
    private Button names;

    @FXML
    private TextArea taOutput;

    @FXML
    private TextField tf1Entered;

    @FXML
    private TextField tf2Entered;

    @FXML
    void showNames(ActionEvent event) {
        Player p1 = new Player(tf1Entered.getText());
        Player p2 = new Player(tf2Entered.getText());
        String result = (p1.getPlayerName() + " " + p2.getPlayerName());
        taOutput.setText(result);
    }

}
