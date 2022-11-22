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
import javafx.scene.control.ChoiceBox;
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
    private String[] strategies = {"Tit For Tat", "Stealer", "Splitter", "Random"};

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> Choice;

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
        p.setStrategy(Choice.getValue());
        StartView.storePlayers(p);
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Choice.getItems().addAll(strategies);
        
    }



    public void createName(Player player, int i) {
        this.p = player;
        this.playerNumber = i;
        label.setText("Player " + playerNumber);
    }
}
