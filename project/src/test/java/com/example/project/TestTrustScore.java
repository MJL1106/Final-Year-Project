package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrustScore {
    private Player p1,p2;
    
    @BeforeEach
    public void makePlayer(){
        p1 = new Player("Matthew");
        p2 = new Player("James");
    }

    @Test //Tests Trust Score Splitter vs Stealer
    public void testSplitterStealerScore(){
        p1.setStrategy("Splitter");
        p2.setStrategy("Stealer");

        Game.run(p1, p2, 5);
        Game.TrustScore(p1);
        Game.TrustScore(p2);
        
        assertEquals(100,p1.getTrustScore());
        assertEquals(0,p2.getTrustScore());
    }

    @Test //Tests Trust Score Tit For Tat vs Stealer
    public void testTitForTatStealerScore(){
        p1.setStrategy("Tit For Tat");
        p2.setStrategy("Stealer");

        Game.run(p1, p2, 5);
        Game.TrustScore(p1);
        Game.TrustScore(p2);
        
        assertEquals(20,p1.getTrustScore());
        assertEquals(0,p2.getTrustScore());
    }

    @Test //Tests Trust Score Alternator vs Stealer
    public void testAlternatorTitForTatScore(){
        p1.setStrategy("Alternator");
        p2.setStrategy("Tit For Tat");

        Game.run(p1, p2, 5);
        Game.TrustScore(p1);
        Game.TrustScore(p2);
        
        assertTrue(((p1.getTrustScore() == 40)) || (p1.getTrustScore() == 60));
        assertEquals(60,p2.getTrustScore());
    }


    
}
