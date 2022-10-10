package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPlayer {
    @Test
    public void testPlayerName() {
        Player p1 = new Player("Matthew");
        assertEquals(p1.getPlayerName(), "Matthew", "Testing if the player name has been initialised");
    }
}
