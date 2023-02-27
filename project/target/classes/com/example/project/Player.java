package com.example.project;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class to create a Player.
 */
public class Player {
    private String playerName,strategy;
    private int jailTime,roundPoints;
    private ArrayList<String> choices = new ArrayList<String>();

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
     * Sets player's strategy.
     * 
     * @param strat
     */
    public void setStrategy(String strat){
        this.strategy = strat;
    }

    
    /** 
     * Gets the player's strategy.
     * 
     * @return String
     */
    public String getStrategy(){
        return this.strategy;
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
     * Sets the points of the Player.
     * 
     * @param time result of dilemma
     */
    public void setJailTime(int time){
        this.jailTime = time;
    }

    
    /** 
     * Gets the Players total points.
     * 
     * @return int total points
     */
    public int getJailTime(){
        return this.jailTime;
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
}
