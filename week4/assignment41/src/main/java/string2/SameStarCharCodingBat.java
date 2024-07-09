package main.java.string2;

import java.util.Arrays;

public class SameStarCharCodingBat {
    public static void main(String[] args) {
        SameStarCharCodingBat object = new SameStarCharCodingBat();

        System.out.println("sameStarChar(\"xy*yzz\") = " + object.sameStarChar("xy*yzz"));
        System.out.println("sameStarChar(\"xy*zzz\") = " + object.sameStarChar("xy*zzz"));
        System.out.println("sameStarChar(\"*xa*az\") = " + object.sameStarChar("*xa*az"));
    }

    /**
     * Returns true if for every '*' (star) in the string, if there are chars both immediately
     * before and after the star, they are the same.
     * sameStarChar("xy*yzz") → true
     * sameStarChar("xy*zzz") → false
     * sameStarChar("*xa*az") → true
     */

    public boolean sameStarChar(String str) {
        for(int i = 1; i < str.length() - 1; i++){
            if(str.charAt(i) == '*'){
                if(str.charAt(i-1) == str.charAt(i+1)){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
