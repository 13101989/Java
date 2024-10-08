package main.java;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FestivalMain {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();

        List<Runnable> attendeesRunnable = IntStream
                .range(0, 200)
                .mapToObj(_ -> new FestivalAttendeeThread(TicketType.getRandomTicketType(), gate))
                .collect(Collectors.toList());

        try (ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1)) {
            FestivalStatisticsThread gateStats = new FestivalStatisticsThread(gate);
            scheduledExecutorService.scheduleAtFixedRate(gateStats, 5, 5, TimeUnit.SECONDS);

            int numberOfGateEntrances = 10;
            try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfGateEntrances)) {
                attendeesRunnable.forEach(executorService::submit);
            }
            Thread.sleep(5000);
        }
    }
}
