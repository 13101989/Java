package main.java;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Package {
    private final String location;
    private final int distance;
    private final int value;
    private final LocalDate deliveryDate;

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
