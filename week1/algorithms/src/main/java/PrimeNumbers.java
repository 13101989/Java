package main.java;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        int number = 121;
        List<Integer> primesLowerThanNumber = findAllPrimesLowerThanNumber(number);
        System.out.println("Primes lower than number " + number + " are: " + primesLowerThanNumber);
    }

    public static List<Integer> findAllPrimesLowerThanNumber(int number) {
        List<Integer> prime_numbers = new ArrayList<>();

        int number_to_check = number - 1;

        while (number_to_check > 1) {
            if (IsPrime(number_to_check)) {
                prime_numbers.add(number_to_check);
            }
            number_to_check -= 1;
        }
        return prime_numbers;
    }

    public static boolean IsPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
