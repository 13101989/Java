package main.java;

import java.util.Map;

public class Calculator {
    Map<String, Integer> unitMap = Map.of(
            "mm", 1,
            "cm", 10,
            "dm", 100,
            "m", 1000,
            "km", 1000000
    );

    public int add(int a, String aUnit, int b, String bUnit) {
        if (unitMap.containsKey(aUnit) && unitMap.containsKey(bUnit)) {
            return a * unitMap.get(aUnit) + b * unitMap.get(bUnit);
        } else {
            return 0;
        }
    }

    public int subtract(int a, String aUnit, int b, String bUnit) {
        if (unitMap.containsKey(aUnit) && unitMap.containsKey(bUnit)) {
            return a * unitMap.get(aUnit) - b * unitMap.get(bUnit);
        } else {
            return 0;
        }
    }
}
