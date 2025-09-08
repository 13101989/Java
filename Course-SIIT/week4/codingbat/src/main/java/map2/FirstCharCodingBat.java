package main.java.map2;

import java.util.*;

public class FirstCharCodingBat {
    public static void main(String[] args) {
        FirstCharCodingBat object = new FirstCharCodingBat();

        String[] params1 = {"salt", "tea", "soda", "toast"};
        System.out.println("firstChar([\"salt\", \"tea\", \"soda\", \"toast\"]) --> " + object.firstChar(params1));

        String[] params2 = {"aa", "bb", "cc", "aAA", "cCC", "d"};
        System.out.println("firstChar([\"aa\", \"bb\", \"cc\", \"aAA\", \"cCC\", \"d\"]) --> " + object.firstChar(params2));

        String[] params3 = {};
        System.out.println("firstChar([]) --> " + object.firstChar(params3));
    }

    /**
     * Given an array of non-empty strings, return a Map<String, String> with a key for every different
     * first character seen, with the value of all the strings starting with that character appended together
     * in the order they appear in the array.
     * firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
     * firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
     * firstChar([]) → {}
     */

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        List<String> arrayAsList = Arrays.asList(strings);

        for (String string : arrayAsList) {
            String key = String.valueOf(string.charAt(0));
            if (!map.containsKey(key)) {
                map.put(key, string);
            } else {
                map.put(key, map.get(key) + string);
            }
        }
        return map;
    }
}
