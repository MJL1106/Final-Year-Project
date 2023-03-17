package com.example.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MessageFormat {
    public static HBox formatMessagePlayer(Text text) {
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(233,233,235);" +
                            "-fx-background-color: rgb(15,125,242);" + 
                            " -fx-background-radius: 20px;");
        textFlow.setPadding(new Insets(5,10,5,10));
        
                
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(5,5,5,10));
        hBox.getChildren().add(textFlow);

        return hBox;
    }


    public static HBox formatMessageOpponent(Text text) {
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(239,243,255);" +
                    "-fx-background-color: rgb(15,25,242);" +
                    " -fx-background-radius: 20px;");
        textFlow.setPadding(new Insets(5, 10, 5, 10));
        
                
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));
        hBox.getChildren().add(textFlow);

        return hBox;
    }
}
