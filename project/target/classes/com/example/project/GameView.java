package com.example.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class displays the round robin tournament.
 */
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
     * Displays all match ups and their results in the Text Area.
     * 
     * @param selected total players selected for tournament
     * @param playerList list of players created
     * @param matches all match ups created for round robin
     */
    public void displayName(ArrayList<String> matches, ArrayList<Player> playerList, int selected){
        this.selected = selected;
        this.playerList.addAll(playerList);
        this.matches.addAll(matches);

        Random random = new Random();
        int numDilemmaRounds = 2;

        String[] match = new String[]{};
        int[] playerIndex = new int[2];
        int roundNum = 1;
        int totalTournamentPoints1,totalTorunamentPoints2,totalOverall1,totalOverall2;

        for (int i=0; i<matches.size();i++){

            if (i % (selected/2) == 0){
                taOutput.appendText("Round " + roundNum + "\n");
                roundNum+=1;
            }

            match = matches.get(i).split(" vs ");
            playerIndex = Game.getIndexes(playerList, match, selected);
            p1 = playerList.get(playerIndex[0]);
            p2 = playerList.get(playerIndex[1]);

            Game.run(p1,p2,numDilemmaRounds);
            
            taOutput.appendText(
            p1.getPlayerName() + " vs " + p2.getPlayerName() + " | Result: " + p1.getPlayerName() + " points: " 
            + p1.getRoundPoints() + "   " + p2.getPlayerName() + " points: " + p2.getRoundPoints() + "\n" + "\n");

            totalTournamentPoints1 = p1.getRoundPoints()+p1.getJailTime();
            p1.setJailTime(totalTournamentPoints1);
            totalTorunamentPoints2 = p2.getRoundPoints()+p2.getJailTime();
            p2.setJailTime(totalTorunamentPoints2);

            totalOverall1 = p1.getOverallScore() + p1.getRoundPoints();
            p1.setOverallScore(totalOverall1);
            totalOverall2 = p2.getOverallScore() + p2.getRoundPoints();
            p2.setOverallScore(totalOverall2);



            p1.setRoundPoints(0);
            p2.setRoundPoints(0);
            p1.resetChoices();
            p2.resetChoices();
            
            MainView.updatePlayers(p1);
            MainView.updatePlayers(p2);

        }
        taOutput.appendText(numDilemmaRounds + "");
    }

    
    /** 
     * Exits the scene
     * @param event closes the window
     */
    @FXML
    void closeScene(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }


    
    /** 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}