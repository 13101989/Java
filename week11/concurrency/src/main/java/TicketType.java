package main.java;

import java.util.Random;
import java.util.stream.Stream;

public enum TicketType {
    Full,
    FullVIP,
    FreePass,
    OneDay,
    OneDayVIP;

    public static TicketType getRandomTicketType(){
        return Stream.of(TicketType.values())
                .skip(new Random().nextInt(TicketType.values().length))
                .findFirst()
                .orElseThrow();
    }
}
