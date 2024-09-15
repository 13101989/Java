package datetime.week13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.date.format}")
    private String dateFormat;

    @Value("${spring.time.format}")
    private String timeFormat;

    @Value("${spring.profiles.active}")
    private String profile;

    public String getDateFormat() {
        return dateFormat;
    }
    public String getTimeFormat() {
        return timeFormat;
    }

    public String getProfile() {
        return profile;
    }
}
