package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestPlayer {
    @Test
    public void testPlayerName() {
        Player p1 = new Player("Matthew");
        assertEquals(p1.getPlayerName(), "Matthew", "Testing if the player name has been initialised");
    }

    @Test
    public void testChoice() {
        Player p1 = new Player("Matthew");
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("steal");
        arr.add("steal");
        arr.add("steal");
        arr.add("steal");
        p1.setChoice("steal");
        p1.setChoice("steal");
        p1.setChoice("steal");
        p1.setChoice("steal");
        assertEquals(p1.getChoices(), arr, "Testing if the player choice has been set");
    }

    @Test
    public void testJailTime() {
        Player p1 = new Player("Matthew");
        p1.setJailTime(10);
        assertEquals(p1.getJailTime(), 10, "Testing if the player choice has been set");
    }
}
