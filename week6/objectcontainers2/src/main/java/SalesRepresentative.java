package main.java;

public class SalesRepresentative {
    public int numberOfSales;
    public int quotaPerSale;
    public int revenueGenerated;

    public SalesRepresentative(int numberOfSales, int quotaPerSale) {
        this.numberOfSales = numberOfSales;
        this.quotaPerSale = quotaPerSale;
        this.revenueGenerated = this.numberOfSales * this.quotaPerSale;
    }

    public SalesRepresentative[] bubbleSort(SalesRepresentative[] salesRepresentatives) {
        int arrayLength = salesRepresentatives.length;
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < arrayLength; i++) {
            swapped = false;
            for (j = 0; j < arrayLength - i; j++) {
                if (salesRepresentatives[j].revenueGenerated > salesRepresentatives[j + 1].revenueGenerated) {
                    temp = salesRepresentatives[j].revenueGenerated;
                    salesRepresentatives[j].revenueGenerated = salesRepresentatives[j + 1].revenueGenerated;
                    salesRepresentatives[j + 1].revenueGenerated = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return salesRepresentatives;
    }
}
