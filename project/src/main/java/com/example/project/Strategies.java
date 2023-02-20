package com.example.project;

import java.util.Random;

/**
 * Class stores the strategies for the game.
 */
public class Strategies {


    /**
     * This Method finds which strategy player p has chosen.
     * 
     * 
     * @param choice Strategy choice made by the player p
     * @param p Player object who chose the strategy
     * @param opponent Player opponent 
     */
    public static void Choice(String choice, Player p, Player opponent){
        if (choice.equals("Stealer")){
            Stealer(p,opponent);
        }
        if (choice.equals("Splitter")){
            Splitter(p,opponent);
        }
        if (choice.equals("TitForTat")){
            TitForTat(p, opponent);
        }
        if (choice.equals("Random")){
            Random(p, opponent);
        }
        if (choice.equals("Grudger")){
            Grudger(p, opponent);
        }
        if (choice.equals("Alternator")){
            Alternator(p,opponent);
        }
    }

    
    /** 
     * Method for stealer strategy.
     * 
     * @param p Player object
     */
    public static void Stealer(Player p, Player opponent){
        for (int i = 0; i<5; i++){
            p.setChoice("steal");
        }
    }

    
    /** 
     * Method for splitter strategy.
     * 
     * @param p Player object
     */
    public static void Splitter(Player p, Player opponent){
        for (int i = 0; i<5; i++){
            p.setChoice("split");
        }
    }

    
    /** 
     * Method for tit for tat strategy.
     * 
     * @param p Player object
     * @param opponent Player opponent object
     */
    public static void TitForTat(Player p, Player opponent){
        p.setChoice("split");
        for (int i = 1; i<5; i++){
            p.setChoice(opponent.getChoices().get(i-1));
        }
    }

    
    /** 
     * Method for Random strategy.
     * 
     * @param p Player object
     */
    public static void Random(Player p, Player opponent){
        String[] arr = {"split","steal"};
        int selected;
        Random random = new Random();

        for (int i = 0; i<5; i++){
            selected = random.nextInt(arr.length);
            p.setChoice(arr[selected]);
        }
    }
    /**
     * Method for Grudger strategy.
     * 
     * @param p Player object
     * @param opponent Player object of opponent
     */
    public static void Grudger(Player p, Player opponent){
        String oppChoice;
        p.setChoice("split");
        for (int i = 1; i<5; i++){
            oppChoice = opponent.getChoices().get(i-1);
            if (oppChoice.equals("split")){
                p.setChoice("split");
            }else{
                for(int j = i; j<5; j++){
                    p.setChoice("steal");
                    break;
                }
            }
        }
    }
    /**
     * Method for Alternator strategy.
     * 
     * @param p Player object
     */
    public static void Alternator(Player p, Player opponent){
        String[] arr = {"split","steal"};
        int selected;
        Random random = new Random();
        selected = random.nextInt(arr.length);
        p.setChoice(arr[selected]);
        for (int i = 1; i<5; i++){
            if ((p.getChoices().get(i-1)).equals("split")){
                p.setChoice("steal");
            }else{
                p.setChoice("split");
            }
        }
    }
}
