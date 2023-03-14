package com.example.project;

import java.util.ArrayList;
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
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("ForgivingTitForTat")){
            ForgivingTitForTat(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("TwoTitsForTat")){
            TwoTitsForTat(p, opponent);
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
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("Pavlov")){
            Pavlov(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("HardMajority")){
            HardMajority(p, opponent);
        }
        if (choice.replaceAll("\\s+","").equalsIgnoreCase("WinStayLoseSwap")){
            WinStayLoseSwap(p, opponent);
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
     * Method for Forgiving Tit For Tat strategy.
     * 
     * @param p Player object
     * @param opponent Player object
     */
    public static void ForgivingTitForTat(Player p, Player opponent){
        int opponentPast = 2;
        if(p.getChoices().isEmpty()){
            p.setChoice("split");
        }else{
            int prevChoice = p.getChoices().size()-1;
            String choice = opponent.getChoices().get(prevChoice).toString();
            ArrayList<String> recentChoices = new ArrayList<String>();
            recentChoices.addAll(opponent.getChoices().subList(Math.max(0,prevChoice-opponentPast),prevChoice));
            if(choice.equals("steal") && !recentChoices.contains("split")){
                p.setChoice("split");
            }else{
                p.setChoice(choice);
            }
        }
    }

    /**
     * Method for two tits for tat strategy.
     * 
     * @param p Player object
     * @param opponent Player opponent object
     */
    public static void TwoTitsForTat(Player p, Player opponent){
        int opponentPast = 2;
        if(p.getChoices().isEmpty()){
            p.setChoice("split");
        }else{
            int prevChoice = p.getChoices().size()-1;
            String choice = opponent.getChoices().get(prevChoice).toString();
            ArrayList<String> recentChoices = new ArrayList<String>();
            recentChoices.addAll(opponent.getChoices().subList(Math.max(0,prevChoice-opponentPast),prevChoice));
            if(recentChoices.contains("steal")){
                p.setChoice("steal");
            }else{
                p.setChoice(choice);
            }
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
     * @param opponent Opponent player object
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


    /**
     * Method for Pavlov strategy.
     * 
     * @param p Player object
     * @param opponent Opponent player object
     */
    public static void Pavlov(Player p, Player opponent) {
        if (p.getChoices().isEmpty()) {
            p.setChoice("split");
        } else {
            int prevChoice = Math.min(p.getChoices().size() - 1, opponent.getChoices().size() - 1);
            String choiceP = p.getChoices().get(prevChoice).toString();
            String choiceOpp = opponent.getChoices().get(prevChoice).toString();
            if (choiceP.equals(choiceOpp)) {
                p.setChoice(choiceP);
            } else if (choiceP.equals("split")) {
                p.setChoice("steal");
            } else {
                p.setChoice("split");
            }
        }
    }

    /**
     * Method for Hard Majority strategy.
     * 
     * @param p Player object
     * @param opponent Opponent player object
     */
    public static void HardMajority(Player p, Player opponent){
        int totalSplit = 0,totalSteal = 0;
        if(p.getChoices().isEmpty()){
            p.setChoice("steal");
        }else{
            for (int i =0; i < opponent.getChoices().size(); i++){
                if (opponent.getChoices().get(i).toString().equals("split")){
                    totalSplit+=1;
                }else{
                    totalSteal+=1;
                }
            }
            if(totalSplit>=totalSteal){
                p.setChoice("split");
            }else{
                p.setChoice("steal");
            }
        }
    }

    /**
     * Method for Win Stay Lose Swap Strategy.
     * 
     * @param p Player object
     * @param opponent Opponent object
     */
    public static void WinStayLoseSwap(Player p, Player opponent){
        String[] arr = {"split","steal"};
        int selected;
        int[] points = new int[2];
        Random random = new Random();

        if(p.getChoices().isEmpty()){
            selected = random.nextInt(arr.length);
            p.setChoice(arr[selected]);
        }else{
            int prevChoice = Math.min(p.getChoices().size() - 1, opponent.getChoices().size() - 1);
            String choiceP = p.getChoices().get(prevChoice).toString();
            String choiceOpp = opponent.getChoices().get(prevChoice).toString();
            points = Dilemma.compareChoice(choiceP, choiceOpp);
            int pPoints = points[0];
            int oppPoints = points[1];

            if(pPoints>oppPoints){
                p.setChoice(choiceP);
            }else if(pPoints==oppPoints){
                p.setChoice(choiceP);
            }else{
                p.setChoice("steal");
            }
        }
    }
}
