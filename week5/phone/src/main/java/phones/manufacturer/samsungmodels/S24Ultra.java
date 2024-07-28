package main.java.phones.manufacturer.samsungmodels;

import main.java.phones.manufacturer.Samsung;

public class S24Ultra extends Samsung {
    private final String modelName = "Samsung S24 Ultra";
    private final String IMEI = generateIMEI();

    public S24Ultra() {
        super(140, "purple", "aluminium");
    }

    public S24Ultra(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }

    public String getModelName() {
        return modelName;
    }

    public String getIMEI() {
        return IMEI;
    }
}
