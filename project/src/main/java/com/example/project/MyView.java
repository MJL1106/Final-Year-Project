package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class is the controller to the GUI.
 */
public class MyView implements Initializable{


    private Player p;
    private int playerNumber = 0;
    private Stage stage;

    @FXML
    private Label label;

    @FXML
    private TextField Name1;

    @FXML
    private Button names;

    @FXML
    private AnchorPane scenePane;

    
    /** 
     * Sets the name of the players.
     * 
     * @param event on click
     */
    public void enterNames(ActionEvent event) {
        p = new Player(Name1.getText());
        StartView.storePlayers(p);
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }



    public void createName(Player player, int i) {
        this.p = player;
        this.playerNumber = i;
        label.setText("Player " + playerNumber);
    }
}
