package main.java.phones.manufacturer;

import main.java.phones.Phone;

public class Samsung extends Phone {
    private final String manufacturerName = "Samsung";

    public Samsung(Integer batteryLife, String colour, String material) {
        super(batteryLife, colour, material);
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}
