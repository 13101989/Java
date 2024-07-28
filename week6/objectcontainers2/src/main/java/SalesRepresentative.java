package main.java;

public class SalesRepresentative {
    private final int numberOfSales;
    private final int quotaPerSale;
    private final int revenueGenerated;

    public SalesRepresentative(int numberOfSales, int quotaPerSale) {
        this.numberOfSales = numberOfSales;
        this.quotaPerSale = quotaPerSale;
        this.revenueGenerated = this.numberOfSales * this.quotaPerSale;
    }

    public String toString() {
        return "SalesRepresentative{revenue_generated=" + revenueGenerated + "}";
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public int getQuotaPerSale() {
        return quotaPerSale;
    }

    public int getRevenueGenerated() {
        return revenueGenerated;
    }
}
