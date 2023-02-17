package com.hedspi.money.controller.user;

import com.hedspi.money.request.CalendarRequest;
import com.hedspi.money.response.CalendarResponse;
import com.hedspi.money.service.CalendarSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/calendar")
public class CalendarController {
    @Autowired
    private CalendarSevice calendarSevice;

    @PostMapping("")
    private List<CalendarResponse> calendar(@RequestBody CalendarRequest calendarRequest){
        return calendarSevice.calendar(calendarRequest);
    }
}
