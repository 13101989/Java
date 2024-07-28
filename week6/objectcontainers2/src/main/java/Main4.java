package main.java;


public class Main4 {
    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();
        SalesRepresentative representative1 = new SalesRepresentative(10, 100);
        SalesRepresentative representative2 = new SalesRepresentative(10, 200);
        SalesRepresentative representative3 = new SalesRepresentative(10, 50);
        SalesRepresentative representative4 = new SalesRepresentative(10, 300);

        SalesRepresentative[] representatives = {representative1, representative2, representative3, representative4};

        SalesRepresentative[] sortedRepresentatives = bubble.sort(representatives);

        System.out.println("Sorted representatives:");
        for (SalesRepresentative salesRepresentative : sortedRepresentatives) {
            System.out.println(salesRepresentative);
        }

        System.out.println();

        SalesRepresentative[] reversedSortedRepresentatives = bubble.reverse(sortedRepresentatives);
        System.out.println("Reverse sort of representatives:");
        for (SalesRepresentative salesRepresentative : reversedSortedRepresentatives) {
            System.out.println(salesRepresentative);
        }
    }
}
