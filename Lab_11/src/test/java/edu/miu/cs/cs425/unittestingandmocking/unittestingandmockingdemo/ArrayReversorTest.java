package edu.miu.cs.cs425.unittestingandmocking.unittestingandmockingdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArrayReversorTest {

    private ArrayReversor arrayReversor;
    private  ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);




    @BeforeEach
    void setUp() {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        this.arrayReversor = null;
    }

    @Test
    void reverseArray() {
        int [][] test = new int [][] {{1,3},{0},{4,5,9}};
        when(arrayFlattenerService.arrayFlattener(any())).thenReturn(new int [] {1,3,0,4,5,9});
        int [] actual = arrayReversor.reverseArray(test);
        int [] expected = new int [] {9,5,4,0,3,1};
        assertArrayEquals(expected,actual);
    }

    @Test
    void reverseArrayForNull(){
        int [][] test = null;
        int [] actual = arrayReversor.reverseArray(test);
        int [] expected = null;
        assertArrayEquals(expected, actual);
    }

}