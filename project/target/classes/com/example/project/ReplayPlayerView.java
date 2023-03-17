package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * Class displays GUI for creating players.
 */
public class ReplayPlayerView implements Initializable{


    private Player p;
    private int playerNumber = 0;
    private int n = 0;
    private Stage stage;
    private String[] strategies = {"Tit For Tat", "Suspicious Tit For Tat", "Forgiving Tit For Tat", "Two Tits For Tat", 
    "Stealer", "Splitter", "Random", "Grudger", "Alternator", "Pavlov", "Score Based Pavlov", "Hard Majority"};
    private static ArrayList<Player> playersList = new ArrayList<Player>();
    private List<String> messageList = new ArrayList<>();


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

    @FXML
    private VBox vbox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button send;

    @FXML
    private TextField messageToSend;


    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Choice.getItems().addAll(strategies);

    }


    @FXML
    void displayMessage(ActionEvent event) {
        if(!messageToSend.getText().isEmpty()){
            Text text = new Text(messageToSend.getText());
            HBox hBox = new HBox();
            hBox = MessageFormat.formatMessagePlayer(text);

            vbox.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newValue) {
                
                scrollPane.setVvalue((Double)newValue );  
                }
            });
            
            text.setFill(Color.color(0.934,0.945,0.996));
            String formattedMessage = p.getPlayerName() + ": " + text.getText();
            messageList.add(formattedMessage);

            vbox.getChildren().add(hBox);

            messageToSend.setText("");
        }
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
            if(this.n <= playersList.size()-1){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("replayPlayerView.fxml"));
                    Parent root = loader.load();
                        
                    ReplayPlayerView myview = loader.getController();
                    myview.createName(playersList,n,messageList);
        
                    Stage stage = new Stage();
                    stage.setTitle("Create Player");
                    stage.setScene(new Scene(root));  
                    stage.show();
                } catch(Exception e){
                    System.out.println(e);
                }
            }
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
    public void createName(ArrayList<Player> playerList, int i, List<String> messageList) {
        if (messageList != null && !messageList.isEmpty()){
            this.messageList.addAll(messageList);
        }else{
            this.messageList = new ArrayList<>();
        }

        for (int j = 0; j < messageList.size(); j++){
            String message = messageList.get(j);
            Text text = new Text(message);
            HBox hBox = new HBox();
            hBox = MessageFormat.formatMessageOpponent(text);

            vbox.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newValue) {
                
                scrollPane.setVvalue((Double)newValue );  
                }
            });

            text.setFill(Color.color(0.934,0.945,0.996));

            vbox.getChildren().add(hBox);
        }

        if(this.playersList.size() == 0){
            this.playersList.addAll(playerList);
        }
        this.p = playersList.get(i);
        i++;
        this.n = i;
        label.setText("Player: " + p.getPlayerName());
    }
}
