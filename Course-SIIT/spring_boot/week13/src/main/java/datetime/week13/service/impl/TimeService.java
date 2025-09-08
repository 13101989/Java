package datetime.week13.service.impl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {
    public String getDate(String dateFormat) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);

        return localDateTime.format(dateFormatter);
    }

    public String getTime(String timeFormat) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);

        return localDateTime.format(timeFormatter);
    }
}
