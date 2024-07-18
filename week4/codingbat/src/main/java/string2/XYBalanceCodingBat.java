package main.java.string2;

public class XYBalanceCodingBat {
    public static void main(String[] args) {
        XYBalanceCodingBat object = new XYBalanceCodingBat();

        System.out.println("xyBalance(\"aaxbby\") = " + object.xyBalance("aaxbby"));
        System.out.println("xyBalance(\"aaxbb\") = " + object.xyBalance("aaxbb"));
        System.out.println("xyBalance(\"yaaxbb\") = " + object.xyBalance("yaaxbb"));
    }

    /**
     * We'll say that a String is xy-balanced if for all the 'x' chars in the string,
     * there exists a 'y' char somewhere later in the string. So "xxy" is balanced,
     * but "xyx" is not. One 'y' can balance multiple 'x's.
     * Return true if the given string is xy-balanced.
     * xyBalance("aaxbby") → true
     * xyBalance("aaxbb") → false
     * xyBalance("yaaxbb") → false
     */

    public boolean xyBalance(String str) {
        boolean foundX = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'x') {
                foundX = true;
            } else if (str.charAt(i) == 'y' && !foundX) {
                return true;
            }
        }
        return !foundX;
    }
}
