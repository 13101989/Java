package main.java;

public class Main3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String sum = "";
        String difference = "";

        sum = calculator.add(1, "m", 2, "mm", "m");
        difference = calculator.subtract(1, "cm", 2, "mm", "cm");

        System.out.println(sum);
        System.out.println(difference);

        sum = calculator.add(7, "cm", 1, "m", "mm");
        difference = calculator.subtract(6, "cm", 2, "m", "cm");

        System.out.println(sum);
        System.out.println(difference);

        sum = calculator.add(100, "mm", 2, "m", "dm");
        difference = calculator.subtract(3000, "mm", 2, "m", "km");

        System.out.println(sum);
        System.out.println(difference);
    }
}
