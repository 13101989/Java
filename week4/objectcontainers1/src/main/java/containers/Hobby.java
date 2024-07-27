package main.java.containers;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    public String name;
    public int frequency;
    public String frequencyUnit;

    public List<Address> locationsToPractice = new ArrayList<>();

    public Hobby(String name, int frequency, String frequencyUnit) {
        this.name = name;
        this.frequency = frequency;
        this.frequencyUnit = frequencyUnit;
    }

    public void addLocation(Address location) {
        locationsToPractice.add(location);
        System.out.println("New hobby location was added to hobby " + name + " : " + location);
    }

    public void getLocationsToPractice() {
        System.out.println("Locations to practice " + name + " are: ");
        for (Address location : locationsToPractice) {
            System.out.println(location);
        }
    }

    @Override
    public String toString() {
        String returnStatement = "{name=" + name + ", countries_to_practice=";
        for (Address location : locationsToPractice) {
            returnStatement = returnStatement + location.getCountry() + ",";
        }
        returnStatement = returnStatement.substring(0, returnStatement.length() - 1);
        returnStatement += "}";
        return returnStatement;
    }

}
