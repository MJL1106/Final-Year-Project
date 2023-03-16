package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class ReplayPlayerView implements Initializable{


    private Player p;
    private int playerNumber = 0;
    private Stage stage;
    private String[] strategies = {"Tit For Tat", "Suspicious Tit For Tat", "Forgiving Tit For Tat", "Two Tits For Tat", 
    "Stealer", "Splitter", "Random", "Grudger", "Alternator", "Pavlov", "Score Based Pavlov", "Hard Majority"};

    @FXML
    private ChoiceBox<String> Choice;

    @FXML
    private Button helpButton;

    @FXML
    private Label label;

    @FXML
    private Button names;

    @FXML
    private AnchorPane scenePane;


    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Choice.getItems().addAll(strategies);
    }

    @FXML
    void enterNames(ActionEvent event) {
        if(Choice.getValue()==null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("missingStrategyView.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("ERROR");
                stage.setScene(new Scene(root));  
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            p.setStrategy(Choice.getValue());
            MainView.storePlayers(p);
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
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
     * @param i
     */
    public void createName(Player player) {
        this.p = player;
        label.setText("Player: " + p.getPlayerName());
    }
}
