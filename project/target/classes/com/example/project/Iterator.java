package com.example.project;

import java.lang.reflect.Array;

public class Iterator {

    public static void tallyPoints(Player p1, Player p2){
        String p1Choice,p2Choice;
        int[] points = new int[2];
        int total1 = 0;
        int total2 = 0;

        int arrLength = p1.getChoices().size();
        System.out.println(arrLength);

        for (int i = 0; i<=arrLength-1; i++){
            p1Choice = p1.getChoices().get(i);
            p2Choice = p2.getChoices().get(i);

            points = Dilemma.compareChoice(p1Choice,p2Choice);

            total1 = total1 + Array.getInt(points,0);
            total2 = total2 + Array.getInt(points,1);
            p1.setJailTime(total1);
            p2.setJailTime(total2);
        }
    }
}