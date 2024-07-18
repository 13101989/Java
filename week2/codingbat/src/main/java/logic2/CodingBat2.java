package main.java.logic2;

/**
 * Logic 2 -> blackjack:
 * <p>
 * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both
 * go over.
 * <p>
 * blackjack(19, 21) → 21
 * blackjack(21, 19) → 21
 * blackjack(19, 22) → 19
 */

public class CodingBat2 {
    public static void main(String[] args) {
        CodingBat2 codingBat2 = new CodingBat2();
        int nearestTo21 = codingBat2.blackjack(19, 22);

        System.out.println("Nearest to 21: " + nearestTo21);
    }

    public int blackjack(int a, int b) {
        if (a <= 21 && b <= 21) {
            if (a > b) {
                return a;
            }
            return b;
        } else if (a <= 21) {
            return a;
        } else if (b <= 21) {
            return b;
        }
        return 0;
    }
}
