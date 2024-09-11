package datetime.week13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import datetime.week13.service.impl.TimeService;

@RestController
@Controller
public class TimeController {
    TimeService time;

    @Autowired
    public TimeController(TimeService time) {
        this.time = time;
    }

    @GetMapping("/time")
    public String getTime() {
        return time.getTime();
    }
}

