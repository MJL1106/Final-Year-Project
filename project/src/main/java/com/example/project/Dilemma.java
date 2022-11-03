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
        
        if(choice1.equalsIgnoreCase(choice2) && choice1.equalsIgnoreCase("cooperate")){
            points[0] = 1;
            points[1] = 1;
        }else if (choice1.equalsIgnoreCase(choice2) && choice1.equalsIgnoreCase("defect")){
            points[0] = 5;
            points[1] = 5;
        }
        
        if(choice1.equalsIgnoreCase("cooperate") && choice2.equalsIgnoreCase("defect")){
            points[0] = 10;
            points[1] = 0;
        }else if(choice1.equalsIgnoreCase("defect") && choice2.equalsIgnoreCase("cooperate")){
            points[0] = 0;
            points[1] = 10;
        }
        return points;
    }
}
