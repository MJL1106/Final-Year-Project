package com.example.project;

public class Strategies {

    public static void alwaysSteal(Player p){
        for (int i = 0; i<5; i++){
            p.setChoice("steal");
        }
    }

    public static void alwaysSplit(Player p){
        for (int i = 0; i<5; i++){
            p.setChoice("split");
        }
    }

    public static void titForTat(Player p, Player opponent){
        p.setChoice("split");
        for (int i = 1; i<5; i++){
            p.setChoice(opponent.getChoices().get(i-1));
        }
    }
}
