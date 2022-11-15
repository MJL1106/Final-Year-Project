package com.example.project;

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
import javafx.stage.Stage;

public class StartView implements Initializable {
    
    private Integer[] players = {2,4,6,8,10};
    private int selected = 0;
    private static Player p,p1,p2;
    private static ArrayList<Player> playerList = new ArrayList<Player>();

    @FXML
    private Button createPlayers;

    @FXML
    private ChoiceBox<Integer> playerAmount;

    @FXML
    private Button start;

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
    }

    @FXML
    void startGame(ActionEvent event) {
        for (int i = 0; i<selected;i++){
            p1 = playerList.get(i);
            p2 = playerList.get(i+1);
            i++;
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

    public static void storePlayers(Player player){
        p = player;
        playerList.add(p);
    }

}