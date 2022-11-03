package com.example.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestDilemma {
    @Test
    public void testBothCooperate(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 1;
        expected[1] = 1;
        result = Dilemma.compareChoice("cooperate","cooperate");
        assertTrue(Arrays.equals(result,expected), "Tests that cooperating gives 1 point each");
    }

    @Test
    public void testBothDefect(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 5;
        expected[1] = 5;
        result = Dilemma.compareChoice("defect","defect");
        assertTrue(Arrays.equals(result,expected), "Tests that cooperating gives 5 points each");
    }

    @Test
    public void testCooperateDefect(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 10;
        expected[1] = 0;
        result = Dilemma.compareChoice("cooperate","defect");
        assertTrue(Arrays.equals(result,expected), "Tests that cooperating and defecting gives 10 points and 0 points");
    }

    @Test
    public void testDefectCooperate(){
        int[] result = new int[2];
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 10;
        result = Dilemma.compareChoice("defect","cooperate");
        assertTrue(Arrays.equals(result,expected), "Tests that defecting and cooperating gives 0 points and 10 points");
    }
}
