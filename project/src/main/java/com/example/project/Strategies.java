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
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Stealer")){
            Stealer(p,opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Splitter")){
            Splitter(p,opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("TitForTat")){
            TitForTat(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("SuspiciousTitForTat")){
            SuspiciousTitForTat(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Random")){
            Random(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Grudger")){
            Grudger(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Alternator")){
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
            int prevChoice = p.getChoices().size()-1;
            String choice = opponent.getChoices().get(prevChoice).toString();
            p.setChoice(opponent.getChoices().get(prevChoice));
        }
    }

       /**
     * Method for tit for tat strategy.
     * 
     * @param p Player object
     * @param opponent Player opponent object
     */
    public static void SuspiciousTitForTat(Player p, Player opponent){
        if(p.getChoices().isEmpty()){
            p.setChoice("steal");
        }else{
            int prevChoice = p.getChoices().size()-1;
            String choice = opponent.getChoices().get(prevChoice).toString();
            p.setChoice(opponent.getChoices().get(prevChoice));
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
