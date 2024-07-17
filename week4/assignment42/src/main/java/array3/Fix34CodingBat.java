package main.java.array3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fix34CodingBat {
    public static void main(String[] args) {
        Fix34CodingBat object = new Fix34CodingBat();

        int[] params1 = {1, 3, 1, 4};
        System.out.println("fix34([1, 3, 1, 4]) → " + Arrays.toString(object.fix34(params1)));

        int[] params2 = {1, 3, 1, 4, 4, 3, 1};
        System.out.println("fix34([1, 3, 1, 4, 4, 3, 1]) → " + Arrays.toString(object.fix34(params2)));

        int[] params3 = {3, 2, 2, 4};
        System.out.println("fix34([3, 2, 2, 4]) → " + Arrays.toString(object.fix34(params3)));
    }

    /**
     * Return an array that contains exactly the same numbers as the given array,
     * but rearranged so that every 3 is immediately followed by a 4.
     * Do not move the 3's, but every other number may move.
     * The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3,
     * and a 3 appears in the array before any 4.
     * fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
     * fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
     * fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
     */

    public int[] fix34(int[] nums) {
        List<Integer> numsAsList = new ArrayList<>();
        for (Integer num : nums) {
            numsAsList.add(num);
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numsAsList.size(); i++) {
            if (i > 0 && numsAsList.get(i - 1) == 3) {
                temp.add(numsAsList.get(i));
                result.add(4);
            } else {
                result.add(numsAsList.get(i));
            }
        }
        for (int i = 0; i < numsAsList.size(); i++) {
            if (i > 0 && numsAsList.get(i - 1) != 3 && numsAsList.get(i) == 4) {
                result.set(i, temp.get(0));
                temp.remove(0);
            }
        }

        int[] resultAsArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultAsArray[i] = result.get(i);
        }

        return resultAsArray;
    }
}
