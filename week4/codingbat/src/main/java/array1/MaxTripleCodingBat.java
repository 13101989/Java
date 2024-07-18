package main.java.array1;

public class MaxTripleCodingBat {
    public static void main(String[] args) {
        MaxTripleCodingBat object = new MaxTripleCodingBat();

        int[] arrayToCheck1 = {1, 2, 3};
        int[] arrayToCheck2 = {1, 5, 3};
        int[] arrayToCheck3 = {5, 2, 3};

        System.out.println("maxTriple([1, 2, 3]) = " + object.maxTriple(arrayToCheck1));
        System.out.println("maxTriple([1, 5, 3]) = " + object.maxTriple(arrayToCheck2));
        System.out.println("maxTriple([5, 2, 3]) = " + object.maxTriple(arrayToCheck3));
    }

    /**
     * Given an array of ints of odd length, look at the first, last, and middle values in the array
     * and return the largest. The array length will be a least 1.
     * maxTriple([1, 2, 3]) → 3
     * maxTriple([1, 5, 3]) → 5
     * maxTriple([5, 2, 3]) → 5
     */

    public int maxTriple(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int last = nums[nums.length - 1];
        int middle = nums[nums.length / 2];

        return Math.max(first, Math.max(middle, last));
    }
}
