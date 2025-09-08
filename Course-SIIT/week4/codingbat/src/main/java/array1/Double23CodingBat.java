package main.java.array1;

public class Double23CodingBat {
    public static void main(String[] args) {
        Double23CodingBat object = new Double23CodingBat();

        int[] arraytoCheck1 = {2, 2};
        int[] arraytoCheck2 = {3, 3};
        int[] arraytoCheck3 = {2, 3};

        System.out.println("double23([2, 2]) = " + object.double23(arraytoCheck1));
        System.out.println("double23([3, 3]) = " + object.double23(arraytoCheck2));
        System.out.println("double23([2, 3]) = " + object.double23(arraytoCheck3));

    }

    /**
     * Given an int array, return true if the array contains 2 twice, or 3 twice.
     * The array will be length 0, 1, or 2.
     * double23([2, 2]) → true
     * double23([3, 3]) → true
     * double23([2, 3]) → false
     */

    public boolean double23(int[] nums) {
        int count2s = 0;
        int count3s = 0;

        for (int num : nums) {
            if (num == 2) {
                count2s += 1;
            } else if (num == 3) {
                count3s += 1;
            }
            if (count2s > 1 || count3s > 1) {
                return true;
            }
        }
        return false;
    }
}
