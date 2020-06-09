package edu.miu.cs.cs425.unittestingandmocking.unittestingandmockingdemo;

import java.util.Arrays;

public class ArrayFlattener {
    public ArrayFlattener() {
    }
    public int [] flattenArray(int [][] matrix){
        if(matrix == null){
         return null;
        }
        return  Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray();
    }
}
