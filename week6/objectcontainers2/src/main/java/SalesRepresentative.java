package main.java;

/**
 * Represents a sales representative with a number of sales, quota per sale, and revenue generated.
 * The revenue generated is calculated as the product of the number of sales and the quota per sale.
 */
public class SalesRepresentative {
    private final int numberOfSales;
    private final int quotaPerSale;
    private final int revenueGenerated;

    /**
     * Constructs a SalesRepresentative object with the specified number of sales and quota per sale.
     * The revenue generated is calculated as the product of the number of sales and the quota per sale.
     *
     * @param numberOfSales the number of sales made by the sales representative
     * @param quotaPerSale  the quota per sale for the sales representative
     */
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
