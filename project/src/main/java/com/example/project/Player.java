package com.example.project;

/**
 * Class to create a Player.
 */
public class Player {
    private String playerName,choice;
    private int jailTime;

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
     * Sets the Players choice of action.
     * 
     * @param str is the entered decision
     */
    public void setChoice(String str){
        this.choice = str;
    }

    
    /** 
     * Gets the Players choice of action.
     * 
     * @return String choice of Player
     */
    public String getChoice(){
        return this.choice;
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
