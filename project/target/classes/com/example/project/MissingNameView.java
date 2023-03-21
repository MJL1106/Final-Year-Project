package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class displays a warning of empty player name.
 */
public class MissingNameView {
    private Stage stage;

    @FXML
    private Button button;

    @FXML
    private AnchorPane scenepane;

    @FXML
    void startGame(ActionEvent event) {
        stage = (Stage) scenepane.getScene().getWindow();
        stage.close();
    }

}
