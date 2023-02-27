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
        p.setChoice("steal");
    }

    
    /** 
     * Method for splitter strategy.
     * 
     * @param p Player object
     */
    public static void Splitter(Player p, Player opponent){
        p.setChoice("split");
    }

    
    /** 
     * Method for tit for tat strategy.
     * 
     * @param p Player object
     * @param opponent Player opponent object
     */
    public static void TitForTat(Player p, Player opponent){
        if(p.getChoices().isEmpty()){
            p.setChoice("split");  
        }else{
            p.setChoice(opponent.getChoices().get(opponent.getChoices().size()-1));
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

        selected = random.nextInt(arr.length);
        p.setChoice(arr[selected]);
    }


    /**
     * Method for Grudger strategy.
     * 
     * @param p Player object
     * @param opponent Player object of opponent
     */
    public static void Grudger(Player p, Player opponent){
        if(p.getChoices().isEmpty()){
            p.setChoice("split");
        }else if(opponent.getChoices().contains("steal")){
            p.setChoice("steal");
        }else{
            p.setChoice("split");
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

        if(p.getChoices().isEmpty()){
            selected = random.nextInt(arr.length);
            p.setChoice(arr[selected]);
        }else if ((p.getChoices().get(p.getChoices().size()-1)).equals("split")){
            p.setChoice("steal");
        }else{
            p.setChoice("split");
        }
    }
}
