package main.java;

public class Main3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String sum = calculator.add(1, "m", 2, "mm", "m");
        String difference = calculator.subtract(1, "cm", 2, "mm", "cm");

        System.out.println(sum);
        System.out.println(difference);
    }
}
