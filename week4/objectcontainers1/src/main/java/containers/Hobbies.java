package main.java.containers;

import java.util.List;

public class Hobbies {
    public String name;
    public int frequency;
    public String frequencyUnit;
    public List<Address> locationsToPractice;

    public Hobbies(String name, int frequency, String frequencyUnit) {
        this.name = name;
        this.frequency = frequency;
        this.frequencyUnit = frequencyUnit;
    }

    public void addLocation(Address address) {
        locationsToPractice.add(address);
        System.out.println("New hobby location was added. {address = " + address + "}");
    }
}
