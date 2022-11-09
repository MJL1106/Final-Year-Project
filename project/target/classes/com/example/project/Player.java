package com.example.project;

import java.util.ArrayList;

/**
 * Class to create a Player.
 */
public class Player {
    private String playerName,strategy;
    private int jailTime;
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
     * Sets the jail time of the Player.
     * 
     * @param time result of dilemma
     */
    public void setJailTime(int time){
        this.jailTime = time;
    }

    
    /** 
     * Gets the Players jail time.
     * 
     * @return int total time in jail
     */
    public int getJailTime(){
        return this.jailTime;
    }
}
