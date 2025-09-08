package main.java;

import java.util.Random;
import java.util.stream.Stream;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    public static TicketType getRandomTicketType() {
        return Stream.of(TicketType.values())
                .skip(new Random().nextInt(TicketType.values().length))
                .findFirst()
                .orElseThrow();
    }
}
