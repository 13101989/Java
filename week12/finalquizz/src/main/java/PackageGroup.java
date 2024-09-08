package main.java;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PackageGroup {
    String location;
    LocalDate deliveryDate;
    List<Package> packages;

    @Getter
    int totalValue = 0;
    @Getter
    int totalDistance = 0;

    public PackageGroup(String location, LocalDate deliveryDate) {
        this.location = location;
        this.deliveryDate = deliveryDate;
        this.packages = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        packages.add(pkg);
        totalValue += pkg.value;
        totalDistance += pkg.distance;
    }

    public int getRevenue() {
        return packages.stream().mapToInt(pkg -> pkg.distance).sum();
    }

    @Override
    public String toString() {
        return "Location: " + location + ", Date: " + deliveryDate + ", Total Value: " + totalValue + ", Revenue: " + getRevenue() + " LEU";
    }
}
