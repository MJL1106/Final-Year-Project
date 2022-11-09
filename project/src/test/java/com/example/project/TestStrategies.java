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

    @Test
    public void testStealerStealer(){
        Strategies.alwaysSteal(p1);
        Strategies.alwaysSteal(p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(5,p1.getJailTime());
        assertEquals(5,p2.getJailTime());
    }

    @Test
    public void testStealerSplitter(){
        Strategies.alwaysSteal(p1);
        Strategies.alwaysSplit(p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(25,p1.getJailTime());
        assertEquals(0,p2.getJailTime());
    }

    @Test
    public void testTitForTatSplitter(){
        Strategies.alwaysSplit(p2);
        Strategies.titForTat(p1,p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(15,p1.getJailTime());
        assertEquals(15,p2.getJailTime());
    }

    @Test
    public void testTitForTatStealer(){
        Strategies.alwaysSteal(p2);
        Strategies.titForTat(p1,p2);
        Iterator.tallyPoints(p1,p2);
        assertEquals(4,p1.getJailTime());
        assertEquals(9,p2.getJailTime());
    }


}
