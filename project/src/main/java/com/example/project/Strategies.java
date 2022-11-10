package com.example.project;

import java.util.Random;

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

    public static void Random(Player p){
        String[] arr = {"split","steal"};
        int selected;
        Random random = new Random();

        for (int i = 0; i<5; i++){
            selected = random.nextInt(arr.length);
            p.setChoice(arr[selected]);
        }
    }
}
