package main.java.phones.manufacturer.samsungmodels;

import main.java.phones.manufacturer.Samsung;

public class S24 extends Samsung {
    public final String modelName = "Samsung S24";

    public S24() {
        super(90, "purple", "aluminium");
    }

    public S24(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }
}
