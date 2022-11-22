package com.example.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

public class StartView implements Initializable {
    
    private Integer[] players = {2,4,6,8,10};
    private static String[] match = new String[]{};
    private static int[] playerIndex = new int[2];
    private int selected = 0;
    private static Player p,p1,p2;
    private static ArrayList<Player> playerList = new ArrayList<Player>();
    private static ArrayList<String> Players = new ArrayList<String>();
    private static ArrayList<String> Matches = new ArrayList<String>();
    private String result = "";

    @FXML
    private Button createPlayers;

    @FXML
    private Button matches;


    @FXML
    private ChoiceBox<Integer> playerAmount;

    @FXML
    private Button start;

    @FXML
    private Button display;

    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerAmount.getItems().addAll(players);
    }

    
    @FXML
    void makePlayers(ActionEvent event) {
        selected = playerAmount.getValue();
        for (int i = selected; i >0; i--){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("myView.fxml"));
                Parent root = loader.load();
                
                MyView myview = loader.getController();
                myview.createName(p,i);
    
                Stage stage = new Stage();
                stage.setScene(new Scene(root));  
                stage.show();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        createPlayers.setDisable(true);
    }

    @FXML
    void startGame(ActionEvent event) {
        String[] match = new String[]{};
        int[] playerIndex = new int[2];

        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            Players.add(p.getPlayerName());
        }
        Matches.addAll(Game.CreateMatches(Players));

        int rounds = Matches.size();

        for (int i = 0; i<rounds;i++){

            match = Matches.get(i).split(" vs ");
            playerIndex = Game.getIndexes(playerList, match, selected);


            p1 = playerList.get(playerIndex[0]);
            p2 = playerList.get(playerIndex[1]);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
                Parent root = loader.load();
                
                GameView gameView = loader.getController();
                gameView.displayName(p1,p2);
    
                Stage stage = new Stage();
                stage.setScene(new Scene(root));  
                stage.show();
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }

    
    @FXML
    void showPoints(ActionEvent event) {
        taOutput.setText("");
        Collections.sort(playerList, Player.Comparator);
        for(int i=0; i<selected;i++){
            p = playerList.get(i);
            taOutput.appendText(p.getPlayerName() + " " + p.getJailTime() + "\n");
        }
    }

    @FXML
    void showMatches(ActionEvent event) {
        for(int i = 0; i<Matches.size();i++){
            taOutput.appendText(Matches.get(i).toString() + "\n");
        }
    }

    public static void storePlayers(Player player){
        p = player;
        playerList.add(p);
    }

    public static void updatePlayers(Player player){
        p = player;
        int location = 0;
        location = playerList.indexOf(p);
        playerList.set(location,p);
    }

}