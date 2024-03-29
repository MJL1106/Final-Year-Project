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


/**
 * Class displays the main page for the tournament.
 */
public class MainView implements Initializable {
    
    private Integer[] players = {2,4,6,8,10};
    private int selected = 0;
    private static Player p;
    private static ArrayList<Player> playerList = new ArrayList<Player>();
    private static ArrayList<String> Players = new ArrayList<String>();
    private static ArrayList<String> Matches = new ArrayList<String>();

    @FXML
    private Button createPlayers;

    @FXML
    private ChoiceBox<Integer> playerAmount;

    @FXML
    private Button start;

    @FXML
    private Button display;

    @FXML
    private TextArea taOutput;

    @FXML
    private Button replay;

    @FXML
    private AnchorPane scenePane;

    
    /** 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        display.setDisable(true);
        replay.setDisable(true);
        start.setDisable(true);
        playerAmount.getItems().addAll(players);
    }

    /**
     * Method controls the replay ability of the tournament.
     * 
     * @param event button to oppen a popup
     */
    @FXML
    void replayTournament(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("replayView.fxml"));
            Parent root = loader.load();

            ReplayView replayview = loader.getController();
            replayview.createReplay(selected,playerList,Players);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Stage closeStage = new Stage();
            stage.setTitle("Prisoner's Dilemma Game");
            stage.setScene(scene);
            stage.show();
            closeStage = (Stage) scenePane.getScene().getWindow();
            closeStage.close();
            
          } catch(Exception e) {
            e.printStackTrace();
          }
    }
    
    /** 
     * Creates players for the tournament.
     * 
     * @param event
     */
    @FXML
    void makePlayers(ActionEvent event) {
        selected = playerAmount.getValue();
        for (int i = selected; i >0; i--){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("playerView.fxml"));
                Parent root = loader.load();
                
                PlayerView myview = loader.getController();
                myview.createName(p,i);
    
                Stage stage = new Stage();
                stage.setTitle("Create Player");
                stage.setScene(new Scene(root));  
                stage.show();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        createPlayers.setDisable(true);
        start.setDisable(false);
    }

    
    /** 
     * Starts the tournament.
     * 
     * @param event
     */
    @FXML
    void startGame(ActionEvent event) {

        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            Players.add(p.getPlayerName());
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

        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            Game.TrustScore(p);
        }
        
        start.setDisable(true);
        display.setDisable(false);
    }

    
    
    /** 
     * Displays the results of the tournament in decending order.
     * 
     * @param event
     */
    @FXML
    void showPoints(ActionEvent event) {
        replay.setDisable(false);
        taOutput.setText(
        "Tournament Results" + "\n" + 
         "\n" + "Name | Strategy | Trust Score | Total Points" + "\n" + "\n");

        Collections.sort(playerList, Player.Comparator);
        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            taOutput.appendText((i+1) + ". " + p.getPlayerName() + " | " + p.getStrategy() + " | " + p.getTrustScore() + " | " + p.getJailTime() + "\n");
        }
    }

    
    /** 
     * Stores player created in makePlayers().
     * 
     * @param player
     */
    public static void storePlayers(Player player){
        p = player;
        playerList.add(p);
    }

    
    /** 
     * Updates player's stored values that change in GameView.
     * 
     * @param player
     */
    public static void updatePlayers(Player player){
        p = player;
        int location = 0;
        location = playerList.indexOf(p);
        playerList.set(location,p);
    }

}