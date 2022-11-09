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
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("myView.fxml"));
    root.setStyle("-fx-background-color: white");
    Scene scene = new Scene(root);
    scene.getStylesheets().add(MyView.class.getResource("myView.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}