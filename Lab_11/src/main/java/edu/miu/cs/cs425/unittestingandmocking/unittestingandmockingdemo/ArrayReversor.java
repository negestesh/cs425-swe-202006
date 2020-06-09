package edu.miu.cs.cs425.unittestingandmocking.unittestingandmockingdemo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;


public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int [][] matrix) {
//        if (matrix == null){
//            return null;
//        }
        int [] flattenedArray = arrayFlattenerService.arrayFlattener(matrix);
        ArrayUtils.reverse(flattenedArray);
        return flattenedArray;
    }



}
