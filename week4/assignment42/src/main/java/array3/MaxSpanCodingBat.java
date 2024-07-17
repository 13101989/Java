package main.java.array3;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSpanCodingBat {
    public static void main(String[] args) {
        MaxSpanCodingBat object = new MaxSpanCodingBat();

        int[] params1 = {1, 2, 1, 1, 3};
        System.out.println("maxSpan([1, 2, 1, 1, 3]) -> " + object.maxSpan(params1));

        int[] params2 = {1, 4, 2, 1, 4, 1, 4};
        System.out.println("maxSpan([1, 4, 2, 1, 4, 1, 4]) -> " + object.maxSpan(params2));

        int[] params3 = {1, 4, 2, 1, 4, 4, 4};
        System.out.println("maxSpan([1, 4, 2, 1, 4, 4, 4]) -> " + object.maxSpan(params3));
    }

    /**
     * Consider the leftmost and righmost appearances of some value in an array.
     * We'll say that the "span" is the number of elements between the two inclusive.
     * A single value has a span of 1. Returns the largest span found in the given array.
     * (Efficiency is not a priority.)
     * maxSpan([1, 2, 1, 1, 3]) → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */

    public int maxSpan(int[] nums) {
        List<Integer> numsAsList = new ArrayList<>();

        for (Integer num : nums) {
            numsAsList.add(num);
        }

        Map<Integer, Map<String, Integer>> countNums = new HashMap<>();
        int maxSpan = !numsAsList.isEmpty() ? 1 : 0;

        for (int i = 0; i < numsAsList.size(); i++) {
            Integer key = numsAsList.get(i);

            if (!countNums.containsKey(key)) {
                Map<String, Integer> innerMap = new HashMap<>();
                innerMap.put("start", i);
                innerMap.put("span", 1);
                countNums.put(key, innerMap);
            } else {
                Map<String, Integer> innerMap = countNums.get(key);
                int newSpan = i - innerMap.get("start") + 1;
                innerMap.put("span", newSpan);
                maxSpan = Math.max(newSpan, maxSpan);
            }
        }
        return maxSpan;
    }
}
