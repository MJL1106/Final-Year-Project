package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDilemma {
    private Player p1,p2;

    @BeforeEach
    public void createPlayers(){
        p1 = new Player("Matthew");
        p2 = new Player("James");
    }

    @Test
    public void testBothCooperate(){
        p1.setChoice("cooperate");
        p2.setChoice("cooperate");

        String result = Dilemma.compareChoice(p1,p2);
        assertEquals(result, "Matthew you are going to jail for: 1 year(s).\nJames you are going to jail for: 1 year(s).","Tests that when both cooperate their jail time is 1 year.");
    }

    @Test
    public void testBothDefect(){
        p1.setChoice("defect");
        p2.setChoice("defect");

        String result = Dilemma.compareChoice(p1,p2);
        assertEquals(result, "Matthew you are going to jail for: 5 year(s).\nJames you are going to jail for: 5 year(s).","Tests that when both defect their jail time is 5 years.");
    }

    @Test
    public void testCooperateDefect(){
        p1.setChoice("cooperate");
        p2.setChoice("defect");

        String result = Dilemma.compareChoice(p1,p2);
        assertEquals(result, "Matthew you are going to jail for: 10 year(s).\nJames you are going to jail for: 0 year(s).","Tests that when both defect their jail time is 5 years.");
    }

    @Test
    public void testDefectCooperate(){
        p1.setChoice("defect");
        p2.setChoice("cooperate");

        String result = Dilemma.compareChoice(p1,p2);
        assertEquals(result, "Matthew you are going to jail for: 0 year(s).\nJames you are going to jail for: 10 year(s).","Tests that when both defect their jail time is 5 years.");
    }
}
