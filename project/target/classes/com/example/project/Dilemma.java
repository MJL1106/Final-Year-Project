package com.example.project;

/**
 * Class creates the basic prisoners dilemma.
 */

public class Dilemma {
    
    /** 
     * Method implements basic prisoners dilemma to compare choices and set the players jail time.
     * 
     * @param p1 Player1 object
     * @param p2 Player 2 object
     * @return String is the result of the dilemma
     */
    public static String compareChoice(Player p1, Player p2){
        String choice1 = p1.getChoice();
        String choice2 = p2.getChoice();
        String outcome1,outcome2;
        
        if(choice1.equals(choice2) && choice1.equals("cooperate")){
            p1.setJailTime(1);
            p2.setJailTime(1);
        }else if (choice1.equals(choice2) && choice1.equals("defect")){
            p1.setJailTime(5);
            p2.setJailTime(5);
        }
        
        if(choice1.equals("cooperate") && choice2.equals("defect")){
            p1.setJailTime(10);
            p2.setJailTime(0);
        }else if(choice1.equals("defect") && choice2.equals("cooperate")){
            p1.setJailTime(0);
            p2.setJailTime(10);
        }

        outcome1 = (p1.getPlayerName() + " you are going to jail for: " + p1.getJailTime() + " year(s).");
        outcome2 = (p2.getPlayerName() + " you are going to jail for: " + p2.getJailTime() + " year(s).");

        return outcome1 + "\n" + outcome2;
    }
}
