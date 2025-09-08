package main.java.array2;

public class CenteredAverageCodingBat {
    public static void main(String[] args) {
        CenteredAverageCodingBat object = new CenteredAverageCodingBat();

        int[] nums1 = {1, 2, 3, 4, 100};
        int[] nums2 = {1, 1, 5, 5, 10, 8, 7};
        int[] nums3 = {-10, -4, -2, -4, -2, 0};

        System.out.println("centeredAverage([1, 2, 3, 4, 100]) = " + object.centeredAverage(nums1));
        System.out.println("centeredAverage([1, 1, 5, 5, 10, 8, 7]) = " + object.centeredAverage(nums2));
        System.out.println("centeredAverage([-10, -4, -2, -4, -2, 0]) = " + object.centeredAverage(nums3));
    }

    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
     * except ignoring the largest and smallest values in the array.
     * If there are multiple copies of the smallest value, ignore just one copy,
     * and likewise for the largest value. Use int division to produce the final average.
     * You may assume that the array is length 3 or more.
     * centeredAverage([1, 2, 3, 4, 100]) → 3
     * centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
     * centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */

    public int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int meanAverage;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }

        sum = sum - min - max;
        meanAverage = sum / (nums.length - 2);

        return meanAverage;
    }
}
