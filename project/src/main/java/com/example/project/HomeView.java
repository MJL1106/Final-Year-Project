package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Class displays the front page of the program.
 */
public class HomeView {

    @FXML
    private Button button;
    @FXML
    private AnchorPane scenepane;

    @FXML
    void startGame(ActionEvent event) {
        try {

            String css = getClass().getResource("/com/example/project/myView.css").toExternalForm();
            
            Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
            Scene scene = new Scene(root);
            

    
            scene.getStylesheets().add(css);

            Stage stage = new Stage();
            stage.setTitle("Prisoner's Dilemma Game");
            stage.setScene(scene);
            stage.show();

            Stage closeStage = new Stage();
            closeStage = (Stage) scenepane.getScene().getWindow();
            closeStage.close();
            
          } catch(Exception e) {
            e.printStackTrace();
          }
    }

}
