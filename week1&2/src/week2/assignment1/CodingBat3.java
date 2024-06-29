package week2.assignment1;

/**
 * Logic 2 -> makeChocolate:
 * <p>
 * We want to create a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). Return
 * the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
 * <p>
 * makeChocolate(4, 1, 9) → 4
 * makeChocolate(4, 1, 10) → -1
 * makeChocolate(4, 1, 7) → 2
 */


public class CodingBat3 {
    public static void main(String[] args) {
        CodingBat3 codingBat3 = new CodingBat3();
        int smallBarsToUse = codingBat3.makeChocolate(4, 3, 9);

        System.out.println("Small bars to be used: " + smallBarsToUse);
    }

    public int makeChocolate(int small, int big, int goal) {
        int bigBarsNeeded = goal / 5;
        int smallBarsNeeded = 0;

        if (bigBarsNeeded <= big) {
            smallBarsNeeded = goal - (bigBarsNeeded * 5);
        } else {
            smallBarsNeeded = goal - (big * 5);
        }

        if (smallBarsNeeded <= small) {
            return smallBarsNeeded;
        }
        return -1;
    }
}
