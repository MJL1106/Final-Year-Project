package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStrategies {
    private Player p1,p2;
    
    @BeforeEach
    public void makePlayer(){
        p1 = new Player("Matthew");
        p2 = new Player("James)");
    }

    @Test //Tests Steal vs Steal strategy
    public void testStealerStealer(){
        Strategies.alwaysSteal(p1);
        Strategies.alwaysSteal(p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(5,p1.getJailTime());
        assertEquals(5,p2.getJailTime());
    }

    @Test //Tests Steal vs Split strategy
    public void testStealerSplitter(){
        Strategies.alwaysSteal(p1);
        Strategies.alwaysSplit(p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(25,p1.getJailTime());
        assertEquals(0,p2.getJailTime());
    }

    @Test //Tests Tit for Tat vs Split strategy
    public void testTitForTatSplitter(){
        Strategies.alwaysSplit(p2);
        Strategies.titForTat(p1,p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(15,p1.getJailTime());
        assertEquals(15,p2.getJailTime());
    }

    @Test //Test Tit for Tat vs Stealer strategy
    public void testTitForTatStealer(){
        Strategies.alwaysSteal(p2);
        Strategies.titForTat(p1,p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(4,p1.getJailTime());
        assertEquals(9,p2.getJailTime());
    }

    @Test // Tests Tit for Tat vs Random stratgy
    public void testTitForTatRandomWins(){
        p2.setChoice("split");
        p2.setChoice("split");
        p2.setChoice("steal");
        p2.setChoice("split");
        p2.setChoice("steal");
        Strategies.titForTat(p1, p2);
        Iterator.tallyPoints(p1, p2);
        assertEquals(11, p1.getJailTime());
        assertEquals(16, p2.getJailTime());
    }

    @Test // Tests Tit for Tat vs Random stratgy
    public void testTitForTatRandomDraw(){
        p2.setChoice("split");
        p2.setChoice("split");
        p2.setChoice("steal");
        p2.setChoice("split");
        p2.setChoice("split");
        Strategies.titForTat(p1, p2);
        Iterator.tallyPoints(p1, p2);
        assertEquals(14, p1.getJailTime());
        assertEquals(14, p2.getJailTime());
    }


}
