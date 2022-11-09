package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameView implements Initializable {

    private Player p1,p2;
    @FXML
    private TextField Choice1;

    @FXML
    private TextField Choice2;

    @FXML
    private Button compare;

    @FXML
    private Label player1;

    @FXML
    private Label player2;
    
    @FXML
    private TextArea taOutput;

    /** 
     * Displays the points based on the player's inputs.
     * 
     * @param event on click
     */
    @FXML
    void showJailTime(ActionEvent event) {
        p1.setChoice(Choice1.getText());
        p2.setChoice(Choice2.getText());
        Iterator.tallyPoints(p1,p2);
        taOutput.setText(p1.getPlayerName() + " points: " + p1.getJailTime() + "\n" + p2.getPlayerName() + " points: " + p2.getJailTime());
        Choice1.setText("");
        Choice2.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

    public void displayName(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        player1.setText(p1.getPlayerName() + " Enter split/steal:");
        player2.setText(p2.getPlayerName() + " Enter split/steal:");
    }

}