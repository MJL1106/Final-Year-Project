package com.example.project;

import java.util.ArrayList;

public class Game {

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

        if(p1Strategy.equals("Tit For Tat") && !p1Strategy.equals(p2Strategy)){
            Strategies.titForTat(p1, p2);
        }else if(p2Strategy.equals("Tit For Tat") && !p2Strategy.equals(p1Strategy)){
            Strategies.titForTat(p2, p1);
        }else if(p1Strategy.equals("Tit For Tat") && p1Strategy.equals(p2Strategy)){
            Strategies.alwaysSplit(p1);
            Strategies.alwaysSplit(p2);
        }

        Iterator.tallyPoints(p1, p2);
        Iterator.tallyRoundPoints(p1, p2);
    }
    
    public static ArrayList<String> CreateMatches(ArrayList<String> Teams){
        int numDays = (Teams.size() - 1);
        int halfSize = (Teams.size()/2);
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> matches = new ArrayList<>();

        list.addAll(Teams);
        list.remove(0);

        int teamSize = list.size();

        for (int day = 0; day<numDays; day++){
            int teamIdx = day % teamSize;
            matches.add(Teams.get(0) + " vs " + list.get(teamIdx));

            for (int idx = 1; idx < halfSize; idx++){
                int firstTeam = (day + idx) % teamSize;
                int secondTeam = (day + teamSize - idx) % teamSize;
                matches.add(list.get(firstTeam) + " vs " + list.get(secondTeam));
            }
        }
        return matches;
    }

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
