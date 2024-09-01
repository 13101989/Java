package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festival {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();

        List<Thread> attendeeThreads = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            TicketType access = TicketType.getRandomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(access, gate);
            attendeeThreads.add(new Thread(attendee));
        }

        for (Thread thread : attendeeThreads) {
            thread.start();
        }

        FestivalStatisticsThread gateStats = new FestivalStatisticsThread(gate);
        Thread gateStatsThread = new Thread(gateStats);

//        while (true) {
//
//            gateStatsThread.start();
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        Thread.sleep(10000);
        gateStatsThread.start();
        System.out.println(gateStats);
    }
}
