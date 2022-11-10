package com.example.project;

public class Game {

    public static void run(Player p1, Player p2){
        String p1Strategy = p1.getStrategy();
        String p2Strategy = p2.getStrategy();

        if(p1Strategy.equals("Stealer")){
            Strategies.alwaysSteal(p1);
        }else if(p1Strategy.equals("Splitter")){
            Strategies.alwaysSplit(p1);
        }else if(p1Strategy.equals("Random")){
            Strategies.Random(p1);
        }

        if(p2Strategy.equals("Stealer")){
            Strategies.alwaysSteal(p2);
        }else if(p2Strategy.equals("Splitter")){
            Strategies.alwaysSplit(p2);
        }else if(p2Strategy.equals("Random")){
            Strategies.Random(p2);
        }

        if(p1Strategy.equals("Tit For Tat") && !p1Strategy.equals(p2Strategy)){
            Strategies.titForTat(p1, p2);
        }else if(p2Strategy.equals("Tit For Tat") && !p2Strategy.equals(p1Strategy)){
            Strategies.titForTat(p2, p1);
        }else if(p1Strategy.equals("Tit For Tat") && p1Strategy.equals(p2Strategy)){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        }

        Iterator.tallyPoints(p1, p2);
    }
    
}
