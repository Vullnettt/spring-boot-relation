package com.example.springbootrelation.controller;

import com.example.springbootrelation.Models.Schedules;
import com.example.springbootrelation.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesController {

    @Autowired
    private SchedulesService schedulesService;

    @PostMapping("/addSchedules")
    public Schedules saveSchedules(@RequestBody Schedules schedules){
        return this.schedulesService.saveSchedules(schedules);
    }

    @GetMapping("/getAllSchedules")
    public List<Schedules> getAllSchedules(){
        return schedulesService.getAllSchedules();
    }

    @PutMapping("/schedules/{schedulesId}/to/price/{priceId}")
    public Schedules addPriceToSchedules(@PathVariable Long schedulesId, @PathVariable Long priceId){
        return schedulesService.addPriceToSchedules(schedulesId, priceId);
    }
}
