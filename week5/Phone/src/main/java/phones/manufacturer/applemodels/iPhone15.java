package main.java.phones.manufacturer.applemodels;

import main.java.phones.manufacturer.Apple;

public class iPhone15 extends Apple {
    private final String modelName = "iPhone 15";
    private final float IMEI = 123451234512345L;

    public iPhone15() {
        super(100, "light blue", "aluminium");
    }

    public iPhone15(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }

    public String getModelName() {
        return modelName;
    }

    public float getIMEI() {
        return IMEI;
    }
}
