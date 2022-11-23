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

    
    /** 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerAmount.getItems().addAll(players);
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
        start.setDisable(true);
    }

    
    
    /** 
     * Displays the results of the tournament in decending order.
     * 
     * @param event
     */
    @FXML
    void showPoints(ActionEvent event) {
        taOutput.setText("Tournament Results" + "\n");
        Collections.sort(playerList, Player.Comparator);
        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            taOutput.appendText((i+1) + ". " + p.getPlayerName() + " " + p.getJailTime() + "\n");
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