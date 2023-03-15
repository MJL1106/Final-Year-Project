package com.example.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReplayView {
    private int selected = 0;
    private static ArrayList<Player> playerList = new ArrayList<Player>();
    private static ArrayList<String> Players = new ArrayList<String>();
    private static Player p;
    private static ArrayList<String> Matches = new ArrayList<String>();


    @FXML
    private Button display;

    @FXML
    private Button overall;

    @FXML
    private Button replay;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button start;

    @FXML
    private TextArea taOutput;

    @FXML
    private Button updatePlayers;

    @FXML
    void makePlayers(ActionEvent event) {
        for (int i = 0; i<playerList.size();i++){
            p = playerList.get(i);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("replayPlayerView.fxml"));
                Parent root = loader.load();
                
                ReplayPlayerView myview = loader.getController();
                myview.createName(p);
    
                Stage stage = new Stage();
                stage.setTitle("Create Player");
                stage.setScene(new Scene(root));  
                stage.show();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        updatePlayers.setDisable(true);
    }

    @FXML
    void replayTournament(ActionEvent event) {
    }

    @FXML
    void showOverallScores(ActionEvent event) {
        replay.setDisable(false);
        taOutput.setText(
        "Tournament Results" + "\n" + 
        "----------------------" 
        + "\n" + "Name | Strategy | Total Points" + "\n" + "\n");

        Collections.sort(playerList, Player.ComparatorOverall);
        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            taOutput.appendText((i+1) + ". " + p.getPlayerName() + " | " + p.getStrategy() + " | " + p.getOverallScore() + "\n");
        }
    }

    @FXML
    void showPoints(ActionEvent event) {
        replay.setDisable(false);
        taOutput.setText(
        "Tournament Results" + "\n" + 
        "----------------------" 
        + "\n" + "Name | Strategy | Total Points" + "\n" + "\n");

        Collections.sort(playerList, Player.Comparator);
        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            taOutput.appendText((i+1) + ". " + p.getPlayerName() + " | " + p.getStrategy() + " | " + p.getJailTime() + "\n");
        }
    }

    @FXML
    void startGame(ActionEvent event) {

        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            p.setJailTime(0);
            updatePlayers(p);
        }
        Matches.addAll(Game.CreateMatches(Players));

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = loader.load();
            
            GameView gameView = loader.getController();
            gameView.displayName(Matches,playerList,selected);

            Stage stage = new Stage();
            stage.setTitle("Round Robin Matches");
            stage.setScene(new Scene(root));  
            stage.show();
        } catch(Exception e){
            System.out.println(e);
        }



        start.setDisable(true);
        display.setDisable(false);

    }

    public void createReplay(int selected, ArrayList<Player> playersList, ArrayList<String> playersNames){
        replay.setDisable(true);
        display.setDisable(true);
        this.selected = selected;
        this.playerList.addAll(playersList);
        this.Players.addAll(playersNames);
    }

    public static void updatePlayers(Player player) {
        p = player;
        int location = 0;
        location = playerList.indexOf(p);
        playerList.set(location,p);
    }

}
