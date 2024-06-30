import vehicles.carbrands.bmwmodels.Series3;

public class Main {
    public static void main(String[] args) {
        Series3 series3 = new Series3(40, "B-01-DAM");

        series3.start();
        series3.drive(10);
        series3.getAverageFuelConsumption();
        series3.drive(100);
        series3.getAverageFuelConsumption();
        series3.stop();

        series3.start();
        series3.drive(10);
        series3.stop();

    }
}
