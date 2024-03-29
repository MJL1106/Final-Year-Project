package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Main class that runs the interface for the player.
 *
 */
public class Driver extends Application 
{
     /**
   * Main class launches the Gui.
   * 
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Start builds the Gui.
   */
  @Override
    public void start(Stage stage) {
      try {
        
        String css = getClass().getResource("/com/example/project/myView.css").toExternalForm();

        Parent root = FXMLLoader.load(getClass().getResource("homeView.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Prisoner's Dilemma Game");
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        
      } catch(Exception e) {
        e.printStackTrace();
      }
  } 
}