package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class is the controller to the GUI.
 */
public class MyView implements Initializable{


    private Player p1,p2;
    private String[] strategies = {"TitForTat","Splitter","Stealer"};

    @FXML
    private TextField Name1;

    @FXML
    private TextField Name2;

    @FXML
    private Button names;


    
    /** 
     * Sets the name of the players.
     * 
     * @param event on click
     */
    public void enterNames(ActionEvent event) {
        p1 = new Player(Name1.getText());
        p2 = new Player(Name2.getText());

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = loader.load();
            
            GameView gameview = loader.getController();
            gameview.displayName(p1, p2);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
        } catch(Exception e){
            System.out.println(e);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
}
