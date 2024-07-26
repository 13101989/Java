package main.java.phones.manufacturer.applemodels;

import main.java.phones.manufacturer.Apple;

public class iPhone15Pro extends Apple {
    public final String modelName = "iPhone15 Pro";

    public iPhone15Pro() {
        super(150, "dark blue", "titanium");
    }

    public iPhone15Pro(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }
}
