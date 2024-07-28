package main.java;

public class BubbleSort {

    public SalesRepresentative[] sort(SalesRepresentative[] salesRepresentatives) {
        int arrayLength = salesRepresentatives.length;
        int i, j;
        SalesRepresentative temp;
        boolean swapped;

        for (i = 0; i < arrayLength; i++) {
            swapped = false;
            for (j = 0; j < arrayLength - i - 1; j++) {
                if (salesRepresentatives[j].revenueGenerated < salesRepresentatives[j + 1].revenueGenerated) {
                    temp = salesRepresentatives[j];
                    salesRepresentatives[j] = salesRepresentatives[j + 1];
                    salesRepresentatives[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return salesRepresentatives;
    }

    public SalesRepresentative[] reverse(SalesRepresentative[] salesRepresentatives) {
        int arrayLength = salesRepresentatives.length;
        int i;
        SalesRepresentative temp;

        for (i = 0; i < arrayLength / 2; i++) {
            temp = salesRepresentatives[i];
            salesRepresentatives[i] = salesRepresentatives[arrayLength - i - 1];
            salesRepresentatives[arrayLength - i - 1] = temp;
        }
        return salesRepresentatives;
    }
}
