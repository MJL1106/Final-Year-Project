package com.example.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameView implements Initializable{

    private Player p1,p2;
    private Stage stage;
    private ArrayList<String> matches = new ArrayList<String>();
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private int selected;

    @FXML
    private Button exit;

    @FXML
    private TextArea taOutput;

    @FXML
    private AnchorPane scenePane;
    
    /** 
     * Displays player names of current players.
     * 
     * @param p1 player1
     * @param p2 player2
     * @param selected
     * @param playerList
     * @param matches
     */
    public void displayName(ArrayList<String> matches, ArrayList<Player> playerList, int selected){
        this.selected = selected;
        this.playerList.addAll(playerList);
        this.matches.addAll(matches);

        String[] match = new String[]{};
        int[] playerIndex = new int[2];
        int roundNum = 1;
        for (int i=0; i<matches.size();i++){
            if (i % (selected/2) == 0){
                taOutput.appendText("Round " + roundNum + "\n");
                roundNum+=1;
            }
            match = matches.get(i).split(" vs ");
            playerIndex = Game.getIndexes(playerList, match, selected);
            this.p1 = playerList.get(playerIndex[0]);
            this.p2 = playerList.get(playerIndex[1]);
            Game.run(this.p1,this.p2);
            StartView.updatePlayers(this.p1);
            StartView.updatePlayers(this.p2);
            taOutput.appendText(
            this.p1.getPlayerName() + " vs " + this.p2.getPlayerName() + " | Result: " + this.p1.getPlayerName() + " points: " 
            + this.p1.getJailTime() + "   " + this.p2.getPlayerName() + " points: " + this.p2.getJailTime() + "\n" + "\n");
        }
    }

    @FXML
    void closeScene(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}