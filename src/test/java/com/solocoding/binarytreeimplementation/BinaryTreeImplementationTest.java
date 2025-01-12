/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.solocoding.binarytreeimplementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;

/**
 * JUnits testing files.
 *
 * @author guero
 */
public class BinaryTreeImplementationTest {

    private BinaryTreeImplementation mast;

    public BinaryTreeImplementationTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        mast = new BinaryTreeImplementation();
        mast.populateRoot(30);

        mast.populateRoot(40);

        mast.populateRoot(20);

        mast.populateRoot(100);

        mast.populateRoot(0);
        mast.populateRoot(-100);
        mast.populateRoot(27);

        mast.populateRoot(35);
        mast.populateRoot(90);
        mast.populateRoot(80);
        mast.populateRoot(10);
        mast.populateRoot(5);
        mast.populateRoot(12);
        mast.populateRoot(95);
        mast.populateRoot(120);
        mast.populateRoot(115);
        mast.populateRoot(130);
        mast.populateRoot(-200);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPopulateRoot() {
        // BinaryTreeImplementation mast = new BinaryTreeImplementation();

        System.out.println("Print root : " + mast.rootGetter().dataGetter());
      

        assertEquals(30, mast.rootGetter().dataGetter());

        assertEquals(mast.findNode(mast.rootGetter(), 0).dataGetter(), 0);
        assertEquals(mast.findNode(mast.rootGetter(), 80).dataGetter(), 80);
        assertEquals(mast.findNode(mast.rootGetter(), 10).dataGetter(), 10);
        assertNull(mast.findNode(mast.rootGetter(), 1000));
        assertNull(mast.findNode(mast.rootGetter(), 1000));

    }

    /**
     * Method to test edge cases for backTrackCounter method.
     */
    @Test
    public void testBackTrackCounter() {

        int val = mast.backTrackCounter(mast.rootGetter(), 20, 40);
        int val1 = mast.backTrackCounter(mast.rootGetter(), -200, 130);
        int val2 = mast.backTrackCounter(mast.rootGetter(), 30, 12);
        int val3 = mast.backTrackCounter(mast.rootGetter(), -200, 27);
        int val4 = mast.backTrackCounter(mast.rootGetter(), -200, -200);

        assertEquals(2, val);
        assertEquals(8, val1);
        assertEquals(4, val2);
        assertEquals(4, val3);
        assertEquals(0, val4);
    }

    /**
     * Testing edge cases for counting branches from two nodes topdown.
     */
    @Test
    public void testCountBranchesFromNode() {

        assertEquals(mast.countBranchesFromNode(mast.rootGetter().dataGetter(), 0), 2);
        assertEquals(mast.countBranchesFromNode(mast.rootGetter().dataGetter(), 30), 0);
        assertEquals(mast.countBranchesFromNode(0, 5), 2);
        assertEquals(mast.countBranchesFromNode(-200, 5), -1);
        assertEquals(mast.countBranchesFromNode(30, 80), 4);

    }

}
