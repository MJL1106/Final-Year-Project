package com.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class creates the iterated prisoner's dilemma.
 */
public class Iterator {
    /** 
     * Tallies players points for each round.
     * 
     * @param p1 Player 1 object
     * @param p2 Player 2 object
     */
    public static void tallyRoundPoints(Player p1, Player p2){
        String p1Choice,p2Choice;
        int[] points = new int[2];
        int total1 = 0;
        int total2 = 0;

        int arrLength = p1.getChoices().size();

        for (int i = 0; i<=arrLength-1; i++){
            if ((arrLength-i)<=5){
                p1Choice = p1.getChoices().get(i);
                p2Choice = p2.getChoices().get(i);
    
                points = Dilemma.compareChoice(p1Choice,p2Choice);
    
                total1 = total1 + Array.getInt(points,0);
                total2 = total2 + Array.getInt(points,1);
                p1.setRoundPoints(total1);
                p2.setRoundPoints(total2);
            }
        }
    }
}
