package com.example.project;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class to create a Player.
 */
public class Player {
    private String playerName,strategy;
    private int jailTime,roundPoints,overallScore,trustScore;
    private ArrayList<String> choices = new ArrayList<String>();
    private ArrayList<String> strategyHistory = new ArrayList<String>();

    /**
     * A constructor to create a new Player.
     * 
     * @param name
     */
    public Player(String name){
        this.playerName = name;
    }

    
    /** 
     * Gets the name of the Player.
     * 
     * @return String name set by Player
     */
    public String getPlayerName(){
        return this.playerName;
    }

    
    /** 
     * Sets player's strategy and adds to history.
     * 
     * @param strat
     */
    public void setStrategy(String strat){
        this.strategy = strat;
        this.strategyHistory.add(strat);
    }

    
    /** 
     * Gets the player's strategy.
     * 
     * @return String
     */
    public String getStrategy(){
        return this.strategy;
    }

    public ArrayList<String> getStrategyHistory(){
        return this.strategyHistory;
    }
    
    /** 
     * Adds entered choice to list of choices.
     * 
     * @param str String name of choice
     */
    public void setChoice(String str){
        this.choices.add(str);
    }
    

    
    /** 
     * Gets all the choices made by the Player.
     * 
     * @return ArrayList<String> list of choices
     */
    public ArrayList<String> getChoices(){
        return this.choices;
    }

    /**
     * Resets a players choices after each head to head match.
     * 
     */
    public void resetChoices() {
        this.choices.removeAll(this.choices);
    }
    
    /** 
     * Sets the tournament total points of the Player.
     * 
     * @param time result of dilemma
     */
    public void setJailTime(int time){
        this.jailTime = time;
    }

    
    /** 
     * Gets the Players total points for the tournament.
     * 
     * @return int total points
     */
    public int getJailTime(){
        return this.jailTime;
    }

    /**
     * Sets the total points of a Player.
     * 
     * @param points points to be added
     */
    public void setOverallScore(int points){
        this.overallScore = points;
    }

    /**
     * Gets the Players overall points.
     * 
     * @return int overall points
     */
    public int getOverallScore(){
        return this.overallScore;
    }

    
    /** 
     * Sets the points for current round.
     * 
     * @param points result of dilemma
     */
    public void setRoundPoints(int points){
        this.roundPoints = points;
    }

    
    /** 
     * Gets the points for current round.
     * 
     * @return int total points for the round
     */
    public int getRoundPoints(){
        return this.roundPoints;
    }

    /**
     * Compares points to order in decending order.
     * Reference [2] adaptation
     * @return int bigger value
     */
    public static Comparator<Player> Comparator = new Comparator<Player>(){
        public int compare(Player p1, Player p2){
            int time1 = p1.getJailTime();
            int time2 = p2.getJailTime();
            return time2-time1;
        }
    };

     /**
     * Compares points to order in decending order.
     * Reference [2] adaptation
     * @return int bigger value
     */
    public static Comparator<Player> ComparatorOverall = new Comparator<Player>(){
        public int compare(Player p1, Player p2){
            int time1 = p1.getOverallScore();
            int time2 = p2.getOverallScore();
            return time2-time1;
        }
    };
}
