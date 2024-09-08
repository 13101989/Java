package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PackagesLogistic {
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "/Users/valentindamache/Desktop/Java/assignments/Java/week12/finalquizz/src/main/resources/packages.csv";

        List<String> packagesData = loadPackagesFromFile(sourceFilePath);
        List<Package> packages = parsePackagesFromFile(packagesData);

        Map<String, Map<LocalDate, PackageGroup>> groupedPackages = groupPackages(packages);

        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            for (Map.Entry<String, Map<LocalDate, PackageGroup>> locationEntry : groupedPackages.entrySet()) {
                for (Map.Entry<LocalDate, PackageGroup> dateEntry : locationEntry.getValue().entrySet()) {
                    PackageGroup group = dateEntry.getValue();
                    executor.submit(() -> deliverPackages(group));
                }
            }
        }

        printResults(groupedPackages);
    }

    public static List<Package> parsePackagesFromFile(List<String> packagesData) {
        String csvDelimiter = ",";
        List<Package> packages = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String packagesDatum : packagesData) {
            String[] parts = packagesDatum.split(csvDelimiter);
            String location = parts[0];
            int distance = Integer.parseInt(parts[1]);
            int value = Integer.parseInt(parts[2]);
            LocalDate date = LocalDate.parse(parts[3], formatter);
            packages.add(new Package(location, distance, value, date));
        }

        return packages;
    }

    public static List<String> loadPackagesFromFile(String fileName) throws IOException {
        Path file = Paths.get(fileName);
        return Files.readAllLines(file);
    }

    public static Map<String, Map<LocalDate, PackageGroup>> groupPackages(List<Package> packages) {
        Map<String, Map<LocalDate, PackageGroup>> groupedPackages = new HashMap<>();

        for (Package pkg : packages) {
            groupedPackages.computeIfAbsent(pkg.getLocation(), k -> new HashMap<>())
                    .computeIfAbsent(pkg.getDeliveryDate(), k -> new PackageGroup(pkg.getLocation(), pkg.getDeliveryDate()))
                    .addPackage(pkg);
        }

        return groupedPackages;
    }

    public static void deliverPackages(PackageGroup group) {
        System.out.println("--------------------------------------------------");
        for (Package pkg : group.getPackages()) {
            try {
                System.out.println(pkg);
                Thread.sleep(2000); // pkg.getDistance() * 1000L
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------------------------------------");
    }

    private static void printResults(Map<String, Map<LocalDate, PackageGroup>> groupedPackages) {
        int totalDistance = 0;
        int totalPackageValue = 0;
        int totalRevenue = 0;

        System.out.println("\nDelivery Summary:");
        for (Map.Entry<String, Map<LocalDate, PackageGroup>> locationEntry : groupedPackages.entrySet()) {
            for (Map.Entry<LocalDate, PackageGroup> dateEntry : locationEntry.getValue().entrySet()) {
                PackageGroup group = dateEntry.getValue();
                System.out.println(group);
                totalDistance += group.getTotalDistance();
                totalPackageValue += group.getTotalValue();
                totalRevenue += group.getRevenue();
            }
        }

        System.out.println("\nTotal Distance Travelled: " + totalDistance + " km");
        System.out.println("Total Value of Delivered Packages: " + totalPackageValue + " LEU");
        System.out.println("Total Revenue: " + totalRevenue + " LEU");
    }
}
