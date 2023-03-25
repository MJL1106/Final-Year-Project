package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class displays the help page that explains each strategy.
 */
public class HelpView {

    @FXML
    private Button button;

    @FXML
    private AnchorPane scenePane;

    @FXML
    void closeHelp(ActionEvent event) {
        Stage stage = new Stage();
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

}
