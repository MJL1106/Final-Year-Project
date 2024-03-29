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
    public static void run(Player p1, Player p2, int numDilemmaRounds){
        
        for (int i = 0; i<numDilemmaRounds; i++){
            Strategies.Choice(p1.getStrategy(),p1,p2);
            Strategies.Choice(p2.getStrategy(), p2, p1);
        }
        p1.setChoicesHistory(p1.getChoices());
        p2.setChoicesHistory(p2.getChoices());

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

    /**
     * Method calculates the Trust Score of a player.
     * 
     * @param p Player object
     */
    public static void TrustScore(Player p) {
        int totalSplits = 0;
        int totalSteals = 0;
        int trustScore = 0;
        for(int i = 0; i < p.getChoicesHistory().size(); i++){
            String choice = p.getChoicesHistory().get(i);
            if(choice.equals("split")){
                totalSplits++;
            }else{
                totalSteals++;
            }
        }
        trustScore  = (int) (100 * ((double) totalSplits / (totalSplits + totalSteals)));

        p.setTrustScore(trustScore);

    }
}
