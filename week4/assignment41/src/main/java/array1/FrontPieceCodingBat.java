package main.java.array1;

import java.util.Arrays;

public class FrontPieceCodingBat {
    public static void main(String[] args) {
        FrontPieceCodingBat object = new FrontPieceCodingBat();

        int[] arrayToCheck1 = {1, 2, 3};
        int[] arrayToCheck2 = {1, 2};
        int[] arrayToCheck3 = {1};

        System.out.println("frontPiece([1, 2, 3]) = " + Arrays.toString(object.frontPiece(arrayToCheck1)));
        System.out.println("frontPiece([1, 2]) = " + Arrays.toString(object.frontPiece(arrayToCheck2)));
        System.out.println("frontPiece([1]) = " + Arrays.toString(object.frontPiece(arrayToCheck3)));
    }

    /**
     * Given an int array of any length, return a new array of its first 2 elements.
     * If the array is smaller than length 2, use whatever elements are present.
     * frontPiece([1, 2, 3]) → [1, 2]
     * frontPiece([1, 2]) → [1, 2]
     * frontPiece([1]) → [1]
     */

    public int[] frontPiece(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        return Arrays.copyOfRange(nums, 0, 2);
    }
}
