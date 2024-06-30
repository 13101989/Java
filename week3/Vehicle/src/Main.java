import vehicles.carbrands.bmwmodels.Series3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Series3 series3 = new Series3(40, "B-01-DAM");

        System.out.println();

        series3.start();
        series3.drive(10);
        series3.getAverageFuelConsumption();
        series3.getAvailableFuel();
        series3.drive(500);
        series3.getAvailableFuel();
        series3.getAverageFuelConsumption();
        series3.stop();

        System.out.println();

        series3.start();
        series3.shiftGear(1);
        series3.getAvailableFuel();
        series3.drive(100);
        series3.getAverageFuelConsumption();
        series3.getAvailableFuel();
        series3.stop();

        System.out.println();

        series3.start();
        series3.shiftGear(9);
        series3.getAvailableFuel();
        series3.drive(100);
        series3.getAverageFuelConsumption();
        series3.getAvailableFuel();
        series3.stop();

    }
}
