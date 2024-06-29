package week1.assignment2;


public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 1234321;
        boolean isPalindrome = checkIfNumberIsPalindrome(number);
        System.out.println("Is number " + number + " a palindrome: " + isPalindrome);
    }

    public static boolean checkIfNumberIsPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int scale = 1;
        while (number >= scale * 10) {
            scale *= 10;
        }

        while (number > 0) {
            int right = number % 10;
            int left = number / scale;

            if (left == right) {
                number = (number % scale) / 10;
                scale /= 100;
            } else {
                return false;
            }
        }

        return true;
    }
}
