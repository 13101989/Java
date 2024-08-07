package main.java.array2;

public class BigDiffCodingBat {
    public static void main(String[] args) {
        BigDiffCodingBat object = new BigDiffCodingBat();

        int[] nums1 = {10, 3, 5, 6};
        int[] nums2 = {7, 2, 10, 9};
        int[] nums3 = {2, 10, 7, 2};

        System.out.println("bigDiff([10, 3, 5, 6]) = " + object.bigDiff(nums1));
        System.out.println("bigDiff([7, 2, 10, 9]) = " + object.bigDiff(nums2));
        System.out.println("bigDiff([2, 10, 7, 2]) = " + object.bigDiff(nums3));
    }

    /**
     * Given an array length 1 or more of ints, return the difference between the
     * largest and smallest values in the array.
     * Note: the built-in Math.min(v1, v2) and Math.max(v1, v2)
     * methods return the smaller or larger of two values.
     * bigDiff([10, 3, 5, 6]) → 7
     * bigDiff([7, 2, 10, 9]) → 8
     * bigDiff([2, 10, 7, 2]) → 8
     */

    public int bigDiff(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            else if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max - min;
    }
}
