package com.example.project;

import java.util.ArrayList;

/**
 * Class is the main driver for the running of the game.
 */

public class Game {

    
    /** 
     * Method calculates points for head to head of chosen strategies.
     * 
     * @param p1 Player 1
     * @param p2 Player 2
     */
    public static void run(Player p1, Player p2){
        String p1Strategy = p1.getStrategy();
        String p2Strategy = p2.getStrategy();

        if(p1Strategy.equals("Stealer")){
            Strategies.alwaysSteal(p1);
        }else if(p1Strategy.equals("Splitter")){
            Strategies.alwaysSplit(p1);
        }else if(p1Strategy.equals("Random")){
            Strategies.Random(p1);
        }

        if(p2Strategy.equals("Stealer")){
            Strategies.alwaysSteal(p2);
        }else if(p2Strategy.equals("Splitter")){
            Strategies.alwaysSplit(p2);
        }else if(p2Strategy.equals("Random")){
            Strategies.Random(p2);
        }

        if(p1Strategy.equals("Tit For Tat") && (p2Strategy.equals("Grudger"))){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        }else if(p1Strategy.equals("Grudger") && (p2Strategy.equals("Tit For Tat"))){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        } else if(p1Strategy.equals("Tit For Tat") && !p1Strategy.equals(p2Strategy)){
            Strategies.titForTat(p1, p2);
        }else if(p2Strategy.equals("Tit For Tat") && !p2Strategy.equals(p1Strategy)){
            Strategies.titForTat(p2, p1);
        }else if(p1Strategy.equals("Tit For Tat") && (p1Strategy.equals(p2Strategy))){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        }else if(p1Strategy.equals("Grudger") && !p1Strategy.equals(p2Strategy)){
            Strategies.Grudger(p1, p2);
        }else if(p2Strategy.equals("Grudger") && !p2Strategy.equals(p1Strategy)){
            Strategies.Grudger(p2, p1);
        }else if(p1Strategy.equals("Grudger") && (p1Strategy.equals(p2Strategy))){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        }
        Iterator.tallyRoundPoints(p1, p2);
    }
    
    
    /** 
     * Method creates all the matches for the round robin tournament.
     * Reference [1] adaptation.
     * 
     * @param Players Array List of player names
     * @return ArrayList<String> list of all the matches for round robin
     */
    public static ArrayList<String> CreateMatches(ArrayList<String> Players){
        int numRounds = (Players.size() - 1);
        int halfSize = (Players.size()/2);
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> matches = new ArrayList<>();

        list.addAll(Players);
        list.remove(0);

        int teamSize = list.size();

        for (int i = 0; i<numRounds; i++){
            int teamIdx = i % teamSize;
            matches.add(Players.get(0) + " vs " + list.get(teamIdx));

            for (int idx = 1; idx < halfSize; idx++){
                int firstTeam = (i + idx) % teamSize;
                int secondTeam = (i + teamSize - idx) % teamSize;
                matches.add(list.get(firstTeam) + " vs " + list.get(secondTeam));
            }
        }
        return matches;
    }

    
    /** 
     * Method find the position of head to head players in the player list.
     * 
     * @param playerList list of all created players
     * @param match string of head to head match up
     * @param selected total players selected for tournament
     * @return int[] positions of players in player list
     */
    public static int[] getIndexes(ArrayList<Player> playerList, String[] match, int selected){
        String p1Name = match[0];
        String p2Name = match[1];

        int[] indexes = new int[2];

        for(int i=0; i<selected;i++){
            if(playerList.get(i).getPlayerName().equals(p1Name)){
                indexes[0] = i;
            }else if (playerList.get(i).getPlayerName().equals(p2Name)) {
                indexes[1] = i;
            }
        }

        return indexes;
        
    }
    
}
