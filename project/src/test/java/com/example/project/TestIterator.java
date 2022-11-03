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
        p1.setChoice("cooperate");
        p2.setChoice("cooperate");
        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(1,total1);
        assertEquals(1,total2);
    }

    @Test
    public void testdoubleRound(){
        p1.setChoice("cooperate");
        p2.setChoice("cooperate");

        p1.setChoice("cooperate");
        p2.setChoice("cooperate");

        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(2,total1);
        assertEquals(2,total2);
    }

    @Test
    public void testmultiRound(){
        p1.setChoice("cooperate");
        p2.setChoice("cooperate");

        p1.setChoice("cooperate");
        p2.setChoice("cooperate");

        p1.setChoice("defect");
        p2.setChoice("cooperate");

        p1.setChoice("defect");
        p2.setChoice("defect");
        
        Iterator.tallyPoints(p1,p2);
        total1 = p1.getJailTime();
        total2 = p2.getJailTime();
        assertEquals(7,total1);
        assertEquals(17,total2);
    }
}
