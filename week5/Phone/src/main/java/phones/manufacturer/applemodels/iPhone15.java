package main.java.phones.manufacturer.applemodels;

import main.java.phones.manufacturer.Apple;

public class iPhone15 extends Apple {
    public final String modelName = "iPhone 15";

    public iPhone15() {
        super(100, "light blue", "aluminium");
    }

    public iPhone15(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }
}
