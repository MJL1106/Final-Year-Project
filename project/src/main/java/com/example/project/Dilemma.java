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
    public static int[] compareChoice(String choice1, String choice2){
        int[] points = new int[2];
        
        if(choice1.equalsIgnoreCase(choice2) && choice1.equalsIgnoreCase("split")){
            points[0] = 3;
            points[1] = 3;
        }else if (choice1.equalsIgnoreCase(choice2) && choice1.equalsIgnoreCase("steal")){
            points[0] = 1;
            points[1] = 1;
        }
        
        if(choice1.equalsIgnoreCase("split") && choice2.equalsIgnoreCase("steal")){
            points[0] = 0;
            points[1] = 5;
        }else if(choice1.equalsIgnoreCase("steal") && choice2.equalsIgnoreCase("split")){
            points[0] = 5;
            points[1] = 0;
        }
        return points;
    }
}
