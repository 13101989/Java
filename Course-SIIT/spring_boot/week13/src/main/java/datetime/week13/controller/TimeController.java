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

    @GetMapping("/time")
    public String getTime() {
        return "<table border='3'>" +
                    "<tr>" +
                        "<th>" +
                            "&nbsp;&nbsp;Profile&nbsp;&nbsp;" +
                        "</th>" +
                        "<th>" +
                            "Date" +
                        "</th>" +
                        "<th>" +
                            "Hour" +
                        "</th>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>" +
                            "&nbsp;&nbsp;" + appConfig.getProfile() + "&nbsp;&nbsp;" +
                        "</td>" +
                        "<td>" +
                            "&nbsp;&nbsp;" + time.getDate(appConfig.getDateFormat()) + "&nbsp;&nbsp;" +
                        "</td>" +
                        "<td>" +
                            "&nbsp;&nbsp;" + time.getTime(appConfig.getTimeFormat()) + "&nbsp;&nbsp;" +
                        "</td>" +
                    "</tr>" +
                "</table>";
    }
}

