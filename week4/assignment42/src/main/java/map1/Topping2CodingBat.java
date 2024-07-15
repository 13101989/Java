package main.java.map1;

import java.util.HashMap;
import java.util.Map;

public class Topping2CodingBat {
    public static void main(String[] args) {
        Topping2CodingBat object = new Topping2CodingBat();

        Map<String, String> params = new HashMap<>();

        params.put("ice cream", "cherry");
        System.out.println("topping2({\"ice cream\": \"cherry\"}) -→ " + object.topping2(params));
        params.clear();

        params.put("spinach", "dirt");
        params.put("ice cream", "cherry");
        System.out.println("topping2({\"spinach\": \"dirt\", \"ice cream\": \"cherry\"}) -→ " + object.topping2(params));
        params.clear();

        params.put("yogurt", "salt");
        System.out.println("topping2({\"yogurt\": \"salt\"}) -→ " + object.topping2(params));
        params.clear();
    }

    /**
     * Given a map of food keys and their topping values, modify and return the map as follows:
     * if the key "ice cream" has a value, set that as the value for the key "yogurt" also.
     * If the key "spinach" has a value, change that value to "nuts".
     * topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
     * topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
     * topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
     */

    public Map<String, String> topping2(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }
        if (map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }
        return map;
    }
}
