package main.java;

public enum Country {
    DE("Germany"),

    FR("France"),

    NO("Norway"),

    SE("Sweden"),

    US("United States"),

    IT("Italy"),

    AT("Austria"),

    FI("Finland"),

    UK("United Kingdom"),

    RO("Romania");

    public final String country;

    Country(String country) {
        this.country = country;
    }
}
