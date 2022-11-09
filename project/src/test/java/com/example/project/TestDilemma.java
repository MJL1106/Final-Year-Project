package com.example.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestDilemma {
    @Test
    public void testBothCooperate(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 3;
        expected[1] = 3;
        result = Dilemma.compareChoice("split","split");
        assertTrue(Arrays.equals(result,expected), "Tests that splitting gives 3 point each");
    }

    @Test
    public void testBothDefect(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 1;
        expected[1] = 1;
        result = Dilemma.compareChoice("steal","steal");
        assertTrue(Arrays.equals(result,expected), "Tests that stealing gives 1 points each");
    }

    @Test
    public void testCooperateDefect(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 5;
        result = Dilemma.compareChoice("split","steal");
        assertTrue(Arrays.equals(result,expected), "Tests that split and steal gives 0 points and 5 points");
    }

    @Test
    public void testDefectCooperate(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 5;
        expected[1] = 0;
        result = Dilemma.compareChoice("steal","split");
        assertTrue(Arrays.equals(result,expected), "Tests that steal and split gives 5 points and 0 points");
    }
}
