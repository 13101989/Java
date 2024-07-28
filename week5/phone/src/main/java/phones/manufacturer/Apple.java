package main.java.phones.manufacturer;

import main.java.phones.Phone;

public class Apple extends Phone {
    private final String manufacturerName = "Apple";

    public Apple(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}
