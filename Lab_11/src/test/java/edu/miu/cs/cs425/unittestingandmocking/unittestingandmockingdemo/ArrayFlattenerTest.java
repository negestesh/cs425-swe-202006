package edu.miu.cs.cs425.unittestingandmocking.unittestingandmockingdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {
    private ArrayFlattener arrayFlattener;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void flattenArray() {
        arrayFlattener = new ArrayFlattener();
        int [][] input = {{1, 3}, {0}, {4, 5, 9}};
        int [] expected = {1, 3, 0, 4, 5, 9};
        int [] output = arrayFlattener.flattenArray(input);
        assertArrayEquals(expected, output);
    }

    @Test
    void flattenArrayNullInput() {
        arrayFlattener = new ArrayFlattener();
        int [] expected = null ;
        int [] output = arrayFlattener.flattenArray(null);
        assertArrayEquals(expected,output);
    }
}