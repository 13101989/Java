package main.java.map1;

import java.util.HashMap;
import java.util.Map;

public class Topping3CodingBat {
    public static void main(String[] args) {
        Topping3CodingBat object = new Topping3CodingBat();

        Map<String, String> params = new HashMap<>();

        params.put("potato", "ketchup");
        System.out.println("topping3({\"potato\": \"ketchup\"}) --> " + object.topping3(params));
        params.clear();

        params.put("potato", "butter");
        System.out.println("topping3({\"potato\": \"butter\"}) --> " + object.topping3(params));
        params.clear();

        params.put("salad", "oil");
        params.put("potato", "ketchup");
        System.out.println("topping3({\"salad\": \"oil\", \"potato\": \"ketchup\"}) --> " + object.topping3(params));
        params.clear();
    }

    /**
     * Given a map of food keys and topping values, modify and return the map as follows:
     * if the key "potato" has a value, set that as the value for the key "fries".
     * If the key "salad" has a value, set that as the value for the key "spinach".
     * topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
     * topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
     * topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup",
     * "fries": "ketchup"}
     */

    public Map<String, String> topping3(Map<String, String> map) {
        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }
        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }
}
