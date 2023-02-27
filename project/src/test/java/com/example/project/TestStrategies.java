package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStrategies {
    private Player p1,p2;
    
    @BeforeEach
    public void makePlayer(){
        p1 = new Player("Matthew");
        p2 = new Player("James");
    }

    @Test //Tests Steal vs Steal strategy
    public void testStealerStealer(){
        p1.setStrategy("Stealer");
        p2.setStrategy("Stealer");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(), p1, p2);
            Strategies.Choice(p2.getStrategy(), p2, p1);
        }

        Iterator.tallyRoundPoints(p1,p2);
        assertEquals(5,p1.getRoundPoints());
        assertEquals(5,p2.getRoundPoints());
    }

    @Test //Tests Steal vs Split strategy
    public void testStealerSplitter(){
        p1.setStrategy("Stealer");
        p2.setStrategy("Splitter");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(), p1, p2);
            Strategies.Choice(p2.getStrategy(), p2, p1);
        }

        Iterator.tallyRoundPoints(p1,p2);
        assertEquals(25,p1.getRoundPoints());
        assertEquals(0,p2.getRoundPoints());
    }

    @Test //Tests Tit for Tat vs Split strategy
    public void testTitForTatSplitter(){
        p2.setStrategy("Splitter");
        p1.setStrategy("TitForTat");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(),p1,p2);
            Strategies.Choice(p2.getStrategy(),p2,p1);
        }
        Iterator.tallyRoundPoints(p1,p2);
        assertEquals(15,p1.getRoundPoints());
        assertEquals(15,p2.getRoundPoints());
    }

    @Test //Test Tit for Tat vs Stealer strategy
    public void testTitForTatStealer(){
        p2.setStrategy("Stealer");
        p1.setStrategy("TitForTat");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(),p1,p2);
            Strategies.Choice(p2.getStrategy(),p2,p1);
        }
        Iterator.tallyRoundPoints(p1,p2);
        assertEquals(4,p1.getRoundPoints());
        assertEquals(9,p2.getRoundPoints());
    }

    @Test // Tests Tit for Tat vs Random stratgy
    public void testTitForTatRandomWins(){
        p1.setStrategy("TitForTat");
        
        
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("steal");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("steal");

        Iterator.tallyRoundPoints(p1, p2);
        assertEquals(11, p1.getRoundPoints());
        assertEquals(16, p2.getRoundPoints());
    }

    @Test // Tests Tit for Tat vs Random stratgy
    public void testTitForTatRandomDraw(){
        p1.setStrategy("TitForTat");

        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("steal");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        Strategies.Choice(p1.getStrategy(),p1,p2);
        p2.setChoice("split");
        
        Iterator.tallyRoundPoints(p1, p2);
        assertEquals(14, p1.getRoundPoints());
        assertEquals(14, p2.getRoundPoints());
    }

    @Test // Tests Grudger vs Stealer
    public void testGrudgerStealer(){
        p2.setStrategy("Stealer");
        p1.setStrategy("Grudger");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(),p1,p2);
            Strategies.Choice(p2.getStrategy(), p2, p1);;
        }

        Iterator.tallyRoundPoints(p1, p2);
        assertEquals(4,p1.getRoundPoints());
        assertEquals(9,p2.getRoundPoints());
    }

    @Test // Tests Alternator Strategy vs Stealer
    public void testAlternator(){
        p1.setStrategy("Alternator");
        p2.setStrategy("Stealer");

        for (int i = 0; i<5; i++){
            Strategies.Choice(p1.getStrategy(),p1,p2);
            Strategies.Choice(p2.getStrategy(), p2, p1);
        }
        Iterator.tallyRoundPoints(p1, p2);
        assertTrue(((p1.getRoundPoints() == 2)) || (p1.getRoundPoints() == 3));
    }

}
