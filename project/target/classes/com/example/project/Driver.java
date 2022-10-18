package com.example.project;

import java.util.Scanner;

/**
 * Main class that runs the interface for the player.
 *
 */
public class Driver 
{
    public static void main( String[] args )
    {
        Scanner userInput = new Scanner(System.in);
        String playerName;
        String playerChoice;
        System.out.println( "Prisoner's Dilemma" );
        
        System.out.println("Player 1 enter your name: ");
        playerName = userInput.nextLine();
        Player p1 = new Player(playerName);

        System.out.println("Player 2 enter your name: ");
        playerName = userInput.nextLine();
        Player p2 = new Player(playerName);

        System.out.println(p1.getPlayerName() + " do you want to cooperate or defect: ");
        playerChoice = userInput.nextLine();
        p1.setChoice(playerChoice);

        System.out.println(p2.getPlayerName() + " do you want to cooperate or defect: ");
        playerChoice = userInput.nextLine();
        p2.setChoice(playerChoice);

        System.out.println(Dilemma.compareChoice(p1,p2));
    }
}
