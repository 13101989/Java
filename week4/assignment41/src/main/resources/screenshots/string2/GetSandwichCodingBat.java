package main.resources.screenshots.string2;

import java.util.Arrays;

public class GetSandwichCodingBat {
    public static void main(String[] args) {
        GetSandwichCodingBat object = new GetSandwichCodingBat();

        System.out.println("getSandwich(\"breadjambread\") = " + object.getSandwich("breadjambread"));
        System.out.println("getSandwich(\"xxbreadjambreadyy\") = " + object.getSandwich("xxbreadjambreadyy"));
        System.out.println("getSandwich(\"xxbreadyy\") = " + object.getSandwich("xxbreadyy"));

    }

    /**
     * A sandwich is two pieces of bread with something in between.
     * Return the string that is between the first and last appearance of "bread" in the given string,
     * or return the empty string "" if there are not two pieces of bread.
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */

    public String getSandwich(String str) {
        int lengthToCheck = "bread".length();
        int left= 0;
        int right = str.length();

        boolean leftIndexFound = false;
        boolean rightIndexFound = false;

        while (left < right){
            if (!(str.substring(left, left + lengthToCheck).equals("bread"))) {
                left += 1;
            }
//            else{
//                leftIndexFound = true;
//            }

            if (!(str.substring(right - lengthToCheck, right).equals("bread"))){
                right -=1;
            }
//            else{
//                rightIndexFound = true;
//            }
        }

//        if (leftIndexFound && rightIndexFound){
//            return str.substring(left + lengthToCheck, right - lengthToCheck);
//        }

        return str.substring(left + lengthToCheck, right - lengthToCheck);

    }
}
