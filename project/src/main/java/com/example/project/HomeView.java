package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeView {

    @FXML
    private Button button;
    @FXML
    private AnchorPane scenepane;

    @FXML
    void startGame(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Stage closeStage = new Stage();
            stage.setTitle("Prisoner's Dilemma Game");
            stage.setScene(scene);
            stage.show();
            closeStage = (Stage) scenepane.getScene().getWindow();
            closeStage.close();
            
          } catch(Exception e) {
            e.printStackTrace();
          }
    }

}
