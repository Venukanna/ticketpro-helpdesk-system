package com.helpdesk.smart_helpdesk_ticketing.controller;

import com.helpdesk.smart_helpdesk_ticketing.service.DashboardService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService){

        this.dashboardService = dashboardService;
    }

    @GetMapping("/metrics")
    public Map<String, Long> metrics(){

        return dashboardService.getMetrics();

    }

}