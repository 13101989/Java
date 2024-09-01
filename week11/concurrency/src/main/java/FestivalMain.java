package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FestivalMain {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();

        List<Runnable> attendeesRunnable = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            TicketType access = TicketType.getRandomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(access, gate);
            attendeesRunnable.add(attendee);
        }

        try (ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1)) {
            FestivalStatisticsThread gateStats = new FestivalStatisticsThread(gate);
            scheduledExecutorService.scheduleAtFixedRate(gateStats, 0, 5, TimeUnit.SECONDS);

            try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
                for (Runnable attendee : attendeesRunnable) {
                    executorService.submit(attendee);
                }
            }

            Thread.sleep(5000);
        }
    }
}
