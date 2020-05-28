package edu.mum.cs.cs425.demos.studentrecorsmgmtapp;

import java.util.Arrays;

public class FurtherCodingPracticeProblems {
    public static void main(String[] args) {
        int[] integers = {1, 830, 344, 339, 279, 759, 257, 151, 590, 627, 684, 186, 565, 345, 92, 323, 956, 789, 982, 78};
        System.out.println("################-List of Integers-################");
        System.out.println(Arrays.toString(integers));
        System.out.println("################################");
        printHelloWorld(integers);
        System.out.println("################################");
        findSecondBiggest(integers);

    }

    public static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else {
                if (number % 5 == 0) {
                    System.out.println("Hello");
                }
                if (number % 7 == 0) {
                    System.out.println("World");
                }
            }

        }
    }

    public static void findSecondBiggest(int[] numbers) {
        int firstBiggest = numbers[0];
        int secondBiggest = numbers[0];
        int lastFirstBiggest = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > firstBiggest) {
                lastFirstBiggest = firstBiggest;
                firstBiggest = numbers[i];
            }
            if (lastFirstBiggest != firstBiggest) {
                secondBiggest = lastFirstBiggest;
            }
            if (numbers[i - 1] > secondBiggest && numbers[i - 1] < firstBiggest) {
                secondBiggest = numbers[i - 1];
            }
        }
        System.out.println("The Second largest number in this array is : " + secondBiggest);
    }


}
