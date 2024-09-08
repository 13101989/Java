package main.java;

import java.time.LocalDate;

public class Package {
    String location;
    int distance;
    int value;
    LocalDate deliveryDate;

    public Package(String location, int distance, int value, LocalDate deliveryDate) {
        this.location = location;
        this.distance = distance;
        this.value = value;
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "[Delivering for <" + location + "> and date <" + deliveryDate + "> in <" + distance + "> seconds a package with value <" + value + ">]";
    }

}
