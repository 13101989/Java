package main.java.array2;

import java.util.Arrays;

public class Pre4CodingBat {
    public static void main(String[] args) {
        Pre4CodingBat object = new Pre4CodingBat();

        int[] nums1 = {1, 2, 4, 1};
        int[] nums2 = {3, 1, 4};
        int[] nums3 = {1, 4, 4};

        System.out.println("pre4([1, 2, 4, 1]) = " + Arrays.toString(object.pre4(nums1)));
        System.out.println("pre4([3, 1, 4]) = " + Arrays.toString(object.pre4(nums2)));
        System.out.println("pre4([1, 4, 4]) = " + Arrays.toString(object.pre4(nums3)));
    }

    /**
     * Given a non-empty array of ints, return a new array containing the elements from the original array
     * that come before the first 4 in the original array. The original array will contain at least one 4.
     * Note that it is valid in java to create an array of length 0.
     * pre4([1, 2, 4, 1]) → [1, 2]
     * pre4([3, 1, 4]) → [3, 1]
     * pre4([1, 4, 4]) → [1]
     */

    public int[] pre4(int[] nums) {
        int first4Index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                first4Index = i;
                break;
            }
        }
        return Arrays.copyOfRange(nums, 0, first4Index);
    }
}
