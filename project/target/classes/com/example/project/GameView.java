package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameView implements Initializable{

    private Player p1,p2;
    private String[] strategies = {"Tit For Tat", "Stealer", "Splitter", "Random"};
    private Stage stage;
    

    @FXML
    private Button compare;

    @FXML
    private Button exit;


    @FXML
    private Label player1;

    @FXML
    private Label player2;
    
    @FXML
    private ChoiceBox<String> Choice1;

    @FXML
    private ChoiceBox<String> Choice2;

    @FXML
    private TextArea taOutput;

    @FXML
    private AnchorPane scenePane;


    /** 
     * Displays the points based on the player's inputs.
     * 
     * @param event on click
     */
    @FXML
    void showJailTime(ActionEvent event) {
        p1.setStrategy(Choice1.getValue());
        p2.setStrategy(Choice2.getValue());
        Game.run(p1,p2);
        taOutput.setText(p1.getPlayerName() + " points: " + p1.getJailTime() + "\n" + p2.getPlayerName() + " points: " + p2.getJailTime());
        StartView.updatePlayers(p1);
        StartView.updatePlayers(p2);
    }

    
    /** 
     * Displays player names of current players.
     * 
     * @param p1 player1
     * @param p2 player2
     */
    public void displayName(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        player1.setText(p1.getPlayerName() + " Choose strategy:");
        player2.setText(p2.getPlayerName() + " Choose strategy:");  
    }

    @FXML
    void closeScene(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Choice1.getItems().addAll(strategies);
        Choice2.getItems().addAll(strategies);
    }

}