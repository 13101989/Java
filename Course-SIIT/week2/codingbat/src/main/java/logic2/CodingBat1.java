package main.java.logic2;

/**
 * Logic 2 -> noTeenSum:
 * <p>
 * Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19
 * inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. Write a separate helper
 * "public int fixTeen(int n) {" that takes in an int value and returns that value fixed for the teen rule. In this
 * way, you avoid repeating the teen code 3 times (i.e. "decomposition"). Define the helper below and at the same
 * indent level as the main noTeenSum().
 * <p>
 * noTeenSum(1, 2, 3) → 6
 * noTeenSum(2, 13, 1) → 3
 * noTeenSum(2, 1, 14) → 3
 */

public class CodingBat1 {
    public static void main(String[] args) {
        CodingBat1 codingBat1 = new CodingBat1();
        int sumWithoutTeen = codingBat1.noTeenSum(2, 1, 17);

        System.out.println("Sum of numbers without teens: " + sumWithoutTeen);
    }

    public int noTeenSum(int a, int b, int c) {
        return this.helper(a) + this.helper(b) + this.helper(c);
    }

    private int helper(int number) {
        if ((number >= 13 && number < 15) || (number >= 17 && number <= 19)) {
            return 0;
        }
        return number;
    }
}

