package main.java.phones.manufacturer;

import main.java.phones.Phone;

public class Samsung extends Phone {
    public final String manufacturerName = "Samsung";

    public Samsung(Integer batteryLife, String colour, String material) {
        super(batteryLife, colour, material);
    }
}
