package main.java.string1;

public class ExtraEndCodingBat {
    public static void main(String[] args) {
        ExtraEndCodingBat object = new ExtraEndCodingBat();

        System.out.println("extraEnd('Hello') = " + object.extraEnd("Hello"));
        System.out.println("extraEnd('ab') = " + object.extraEnd("ab"));
        System.out.println("extraEnd('Hi') = " + object.extraEnd("Hi"));
    }

    /**
     * Given a string, return a new string made of 3 copies of the last 2 chars of the original string.
     * The string length will be at least 2.
     * extraEnd("Hello") → "lololo"
     * extraEnd("ab") → "ababab"
     * extraEnd("Hi") → "HiHiHi"
     */

    public String extraEnd(String str) {
        String end = str.substring(str.length() - 2);

        return end + end + end;
    }
}
