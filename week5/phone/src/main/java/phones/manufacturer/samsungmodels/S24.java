package main.java.phones.manufacturer.samsungmodels;

import main.java.phones.manufacturer.Samsung;

public class S24 extends Samsung {
    private final String modelName = "Samsung S24";
    private final String IMEI = generateIMEI();

    public S24() {
        super(4, "purple", "aluminium");
    }

    public S24(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }

    public String getModelName() {
        return modelName;
    }

    public String getIMEI() {
        return IMEI;
    }
}
