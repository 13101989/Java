package main.java.containers;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    private String name;
    private int frequency;
    private String frequencyUnit;

    private List<Address> locationsToPractice = new ArrayList<>();

    public Hobby(String name, int frequency, String frequencyUnit) {
        this.name = name;
        this.frequency = frequency;
        this.frequencyUnit = frequencyUnit;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getFrequencyUnit() {
        return frequencyUnit;
    }

    public void setFrequencyUnit(String frequencyUnit) {
        this.frequencyUnit = frequencyUnit;
    }

    public void getLocationsToPractice() {
        System.out.println("Locations to practice " + name + " are: ");
        for (Address location : locationsToPractice) {
            System.out.println(location);
        }
    }

    public void addLocationToPractice(Address locationToPractice) {
        locationsToPractice.add(locationToPractice);
        System.out.println("New hobby location was added to hobby " + name + " : " + locationToPractice);
    }

}
