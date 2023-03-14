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
 * Class displays GUI for creating players.
 */
public class PlayerView implements Initializable{


    private Player p;
    private int playerNumber = 0;
    private Stage stage;
    private String[] strategies = {"Tit For Tat", "Suspicious Tit For Tat", "Forgiving Tit For Tat", "Two Tits For Tat", "Stealer", "Splitter", "Random", "Grudger", "Alternator", "Pavlov", "Hard Majority"};

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> Choice;

    @FXML
    private TextField Name1;

    @FXML
    private Button names;

    @FXML
    private Button helpButton;

    @FXML
    private AnchorPane scenePane;

    
    /** 
     * Sets the name of the players and their strategy.
     * 
     * @param event on click
     */
    public void enterNames(ActionEvent event) {
        p = new Player(Name1.getText());
        p.setStrategy(Choice.getValue());
        MainView.storePlayers(p);
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }



    
    /** 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Choice.getItems().addAll(strategies);
        
    }


    @FXML
    void showHelp(ActionEvent event) {
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("helpView.fxml"));
            Scene scene = new Scene(root);
            Stage stagehelp = new Stage();
            stagehelp.setTitle("Help Page");
            stagehelp.setScene(scene);
            stagehelp.show();
            
          } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    /** 
     * Displays the number of player being created.
     * 
     * @param player Player object to be created
     * @param i numbered player
     */
    public void createName(Player player, int i) {
        this.p = player;
        this.playerNumber = i;
        label.setText("Player " + playerNumber);
    }
}
