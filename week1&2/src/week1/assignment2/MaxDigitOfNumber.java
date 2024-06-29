package week1.assignment2;


public class MaxDigitOfNumber {
    public static void main(String[] args) {
        int number = 1287;
        int maxDigitOfNumber = getMaxDigitOfNumber(number);
        System.out.println("Max digit of number " + number + " is: " + maxDigitOfNumber);
    }

    public static int getMaxDigitOfNumber(int number) {
        int max = 0;

        if (number < 0) {
            number = -number;
        }

        while (number > 0) {
            max = (number % 10 > max) ? number % 10 : max;
            number /= 10;
        }

        return max;
    }
}
