package main.java;

public enum Country {
    Norway("NOR"),
    Sweden("SWE"),
    Germany("GER"),
    France("FRA"),
    Italy("ITA"),
    Austria("AUT"),
    CzechRepublic("CZE"),
    Switzerland("SUI"),
    UnitedStates("USA"),
    Canada("CAN"),
    Finland("FIN"),
    UnitedKingdom("GBR"),
    Japan("JPN");

    public final String abbreviation;

    Country(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
