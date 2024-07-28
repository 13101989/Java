package main.java;

import java.util.List;

public class SalesRepresentative {
    public int numberOfSales;
    public int quotaPerSale;
    public int revenueGenerated;

    public SalesRepresentative(int numberOfSales, int quotaPerSale) {
        this.numberOfSales = numberOfSales;
        this.quotaPerSale = quotaPerSale;
        this.revenueGenerated = this.numberOfSales * this.quotaPerSale;
    }

    public List<SalesRepresentative> sort(SalesRepresentative salesRepresentative) {

    }
}
