package main.java.phones.manufacturer;

import main.java.phones.Phone;

public class Apple extends Phone {
    public final String manufacturerName = "Apple";

    public Apple(Integer batteryLife, String color, String material) {
        super(batteryLife, color, material);
    }
}
