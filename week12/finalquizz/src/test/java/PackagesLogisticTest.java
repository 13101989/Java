package test.java;

import main.java.PackageGroup;
import main.java.Package;
import main.java.PackagesLogistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PackagesLogisticTest {

    private Package testPackage;
    private PackageGroup testGroup;

    @BeforeEach
    void setUp() {
        testPackage = new Package("Apahida", 15, 100, LocalDate.of(2017, 9, 1));
        testGroup = new PackageGroup("Apahida", LocalDate.of(2017, 9, 1));
    }

    @Test
    void testPackageCreation() {
        assertEquals("Apahida", testPackage.location);
        assertEquals(15, testPackage.distance);
        assertEquals(100, testPackage.value);
        assertEquals(LocalDate.of(2017, 9, 1), testPackage.deliveryDate);
    }

    @Test
    void testPackageGroupCreation() {
        testGroup.addPackage(testPackage);
        assertEquals(1, testGroup.packages.size());
        assertEquals(100, testGroup.getTotalValue());
        assertEquals(15, testGroup.getTotalDistance());
        assertEquals(15, testGroup.getRevenue());  // 15 km * 1 LEU
    }

    @Test
    void testGroupingPackages() {
        List<Package> packages = List.of(
                new Package("Apahida", 15, 100, LocalDate.of(2017, 9, 1)),
                new Package("Apahida", 15, 150, LocalDate.of(2017, 9, 1)),
                new Package("Floresti", 7, 200, LocalDate.of(2017, 9, 2))
        );

        Map<String, Map<LocalDate, PackageGroup>> groupedPackages = PackagesLogistic.groupPackages(packages);

        // Assert there are two locations: Apahida and Floresti
        assertEquals(2, groupedPackages.size());

        // Check for packages in Apahida on 2017-09-01
        PackageGroup groupApahida = groupedPackages.get("Apahida").get(LocalDate.of(2017, 9, 1));
        assertNotNull(groupApahida);
        assertEquals(2, groupApahida.packages.size());

        // Check for package in Floresti on 2017-09-02
        PackageGroup groupFloresti = groupedPackages.get("Floresti").get(LocalDate.of(2017, 9, 2));
        assertNotNull(groupFloresti);
        assertEquals(1, groupFloresti.packages.size());
    }

    @Test
    void testFileLoading() throws IOException {
        // Create a temporary file for testing
        File tempFile = File.createTempFile("test-packages", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("Apahida,15,100,2017-09-01\n");
        writer.write("Floresti,7,200,2017-09-02\n");
        writer.close();

        List<String> packagaData = PackagesLogistic.loadPackagesFromFile(tempFile.getAbsolutePath());
        List<Package> loadedPackages = PackagesLogistic.parsePackagesFromFile(packagaData);

        assertEquals(2, loadedPackages.size());
        assertEquals("Apahida", loadedPackages.get(0).location);
        assertEquals(15, loadedPackages.get(0).distance);
        assertEquals(100, loadedPackages.get(0).value);
        assertEquals(LocalDate.of(2017, 9, 1), loadedPackages.get(0).deliveryDate);

        assertEquals("Floresti", loadedPackages.get(1).location);
        assertEquals(7, loadedPackages.get(1).distance);
        assertEquals(200, loadedPackages.get(1).value);
        assertEquals(LocalDate.of(2017, 9, 2), loadedPackages.get(1).deliveryDate);

        // Clean up temporary file
        tempFile.deleteOnExit();
    }

    @Test
    void testDeliverySimulation() {
        testGroup.addPackage(testPackage);

        Thread deliveryThread = new Thread(() -> PackagesLogistic.deliverPackages(testGroup));
        deliveryThread.start();

        try {
            deliveryThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            fail("Delivery thread was interrupted");
        }

        assertSame(deliveryThread.getState(), Thread.State.TERMINATED);
    }
}