package datetime.week13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.time.format}")
    private String timeFormat;

    public String getTimeFormat() {
        return timeFormat;
    }
}
