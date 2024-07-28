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

    public String toString() {
        return "SalesRepresentative{revenue_generated=" + revenueGenerated + "}";
    }
}
