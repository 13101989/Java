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

    public String add(int a, String aUnit, int b, String bUnit, String outputUnit) {
        if (unitMap.containsKey(aUnit) && unitMap.containsKey(bUnit) && unitMap.containsKey(outputUnit)) {
            float result = (float) (a * unitMap.get(aUnit) + b * unitMap.get(bUnit)) / unitMap.get(outputUnit);
            return a + " " + aUnit + " + " + b + " " + bUnit + " = " + result + " " + outputUnit;
        }
        return "Please enter a valid unit (supported formats: mm, cm, dm, m, km).";
    }

    public String subtract(int a, String aUnit, int b, String bUnit, String outputUnit) {
        if (unitMap.containsKey(aUnit) && unitMap.containsKey(bUnit) && unitMap.containsKey(outputUnit)) {
            float result = (float) (a * unitMap.get(aUnit) - b * unitMap.get(bUnit)) / unitMap.get(outputUnit);
            return a + " " + aUnit + " - " + b + " " + bUnit + " = " + result + " " + outputUnit;
        }
        return "Please enter a valid unit (supported formats: mm, cm, dm, m, km).";
    }
}
