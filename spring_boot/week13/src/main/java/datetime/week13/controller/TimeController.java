package datetime.week13.controller;

import datetime.week13.config.AppConfig;
import datetime.week13.service.impl.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final AppConfig appConfig;
    private final TimeService time;

    public TimeController(AppConfig appConfig, TimeService time) {
        this.appConfig = appConfig;
        this.time = time;
    }

    @GetMapping(value = "/time", produces = MediaType.TEXT_HTML_VALUE)
    public String getTime() {
        return "<table border='3'>" +
                    "<tr>" +
                        "<th>" +
                            "Date & Hour" +
                        "</th>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>" +
                            time.getTime(appConfig.getTimeFormat()) +
                        "</td>" +
                    "</tr>" +
                "</table>";
    }
}

