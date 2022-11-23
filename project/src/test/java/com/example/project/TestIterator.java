package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIterator {
    private Player p1,p2;
    private int total1= 0;
    private int total2= 0;
    
    @BeforeEach
    public void makePlayer(){
        p1 = new Player("Matthew");
        p2 = new Player("James)");
    }
    
    @Test
    public void testSingleRound(){
        p1.setChoice("split");
        p2.setChoice("split");
        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(3,total1, "Tests that splitting gives 3 points");
        assertEquals(3,total2, "Tests that splitting gives 3 points");
    }

    @Test
    public void testdoubleRound(){
        p1.setChoice("split");
        p2.setChoice("split");

        p1.setChoice("split");
        p2.setChoice("split");

        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(6,total1, "Tests that split,split gives 6 points");
        assertEquals(6,total2, "Tests that split,split gives 6 points");
    }

    @Test
    public void testmultiRound(){
        p1.setChoice("split");
        p2.setChoice("split");

        p1.setChoice("split");
        p2.setChoice("split");

        p1.setChoice("steal");
        p2.setChoice("split");

        p1.setChoice("steal");
        p2.setChoice("steal");
        
        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(12,total1, "Tests multiple round game");
        assertEquals(7,total2,"Tests multiple round game");
    }
}
