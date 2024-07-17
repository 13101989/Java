package main.java.array3;

import java.util.ArrayList;
import java.util.List;

public class CanBalanceCodingBat {
    public static void main(String[] args) {
        CanBalanceCodingBat object = new CanBalanceCodingBat();

        int[] params1 = {1, 1, 1, 2, 1};
        System.out.println("canBalance([1, 1, 1, 2, 1]) -> " + object.canBalance(params1));

        int[] params2 = {2, 1, 1, 2, 1};
        System.out.println("canBalance([2, 1, 1, 2, 1]) -> " + object.canBalance(params2));

        int[] params3 = {10, 10};
        System.out.println("canBalance([10, 10]) -> " + object.canBalance(params3));
    }

    /**
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers
     * on one side is equal to the sum of the numbers on the other side.
     * canBalance([1, 1, 1, 2, 1]) → true
     * canBalance([2, 1, 1, 2, 1]) → false
     * canBalance([10, 10]) → true
     */

    public boolean canBalance(int[] nums) {
        List<Integer> numsAsList = new ArrayList<>();
        for (Integer num : nums) {
            numsAsList.add(num);
        }

        int length = numsAsList.size();
        int left = 0;
        int right = length - 1;

        int sumLeft = numsAsList.get(left);
        int sumRight = numsAsList.get(right);

        while (left + 1 < right) {
            if (sumLeft < sumRight) {
                left++;
                sumLeft += numsAsList.get(left);
            } else {
                right--;
                sumRight += numsAsList.get(right);
            }
        }
        return sumLeft == sumRight && numsAsList.size() > 1;
    }
}
