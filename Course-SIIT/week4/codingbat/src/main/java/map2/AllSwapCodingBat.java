package main.java.map2;

import java.util.*;

public class AllSwapCodingBat {
    public static void main(String[] args) {
        AllSwapCodingBat object = new AllSwapCodingBat();

        String[] params1 = {"ab", "ac"};
        System.out.println("allSwap([\"ab\", \"ac\"]) -> " + Arrays.toString(object.allSwap(params1)));

        String[] params2 = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        System.out.println("allSwap([\"ax\", \"bx\", \"cx\", \"cy\", \"by\", \"ay\", \"aaa\", \"azz\"]) -> "
                + Arrays.toString(object.allSwap(params2)));

        String[] params3 = {"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"};
        System.out.println("allSwap([\"ax\", \"bx\", \"ay\", \"by\", \"ai\", \"aj\", \"bx\", \"by\"]) -> "
                + Arrays.toString(object.allSwap(params3)));
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
     * Loop over and then return the given array of non-empty strings as follows:
     * if a string matches an earlier string in the array, swap the 2 strings in the array.
     * When a position in the array has been swapped, it no longer matches anything.
     * Using a map, this can be solved making just one pass over the array.
     * More difficult than it looks.
     * allSwap(["ab", "ac"]) → ["ac", "ab"]
     * allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
     * allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
     */

    public String[] allSwap(String[] strings) {
        Map<String, Map<Integer, String>> map = new HashMap<>();
        String[] result = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String key = String.valueOf(strings[i].charAt(0));

            if (map.containsKey(key)) {
                Map<Integer, String> innerMap = map.get(key);
                if (!innerMap.isEmpty()) {
                    Integer previousIndex = innerMap.keySet().iterator().next();
                    String previousString = innerMap.get(previousIndex);
                    innerMap.remove(previousIndex);
                    result[i] = previousString;
                    result[previousIndex] = strings[i];

                    continue;
                }
            }
            map.computeIfAbsent(key, k -> new HashMap<>()).put(i, strings[i]);
            result[i] = strings[i];
        }
        return result;
    }
}
