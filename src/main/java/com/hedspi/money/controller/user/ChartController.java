package com.hedspi.money.controller.user;

import com.hedspi.money.request.ChartRequest;
import com.hedspi.money.response.BarChartResponse;
import com.hedspi.money.response.PieChartResponse;
import com.hedspi.money.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ChartController {
    @Autowired
    private ChartService chartService;

    @PostMapping("/barchart")
    public BarChartResponse getBarChart(@RequestBody ChartRequest chartRequest){
        return chartService.getBarChart(chartRequest);
    }

    @PostMapping("piechart")
    public PieChartResponse getPierChart(@RequestBody ChartRequest chartRequest){
        return chartService.pie(chartRequest);
    }
}
