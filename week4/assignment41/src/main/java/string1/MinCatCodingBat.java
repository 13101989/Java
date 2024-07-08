package main.java.string1;

import java.util.Arrays;

public class MinCatCodingBat {
    public static void main(String[] args) {

        MinCatCodingBat object = new MinCatCodingBat();

        System.out.println("minCat(\"Hello\", \"Hi\") = " + object.minCat("Hello", "Hi"));
        System.out.println("minCat(\"Hello\", \"java\") = " + object.minCat("Hello", "java"));
        System.out.println("minCat(\"java\", \"Hello\") = " + object.minCat("java", "Hello"));

    }

    /**
     * Given two strings, append them together (known as "concatenation") and return the result.
     * However, if the strings are different lengths, omit chars from the longer string
     * so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi".
     * The strings may be any length.
     * minCat("Hello", "Hi") → "loHi"
     * minCat("Hello", "java") → "ellojava"
     * minCat("java", "Hello") → "javaello"
     */

    public String minCat(String a, String b) {
        int minLength = Math.min(a.length(), b.length());

        String minCat = a.substring(a.length() - minLength) + b.substring(b.length() - minLength);

        return minCat;
    }
}
