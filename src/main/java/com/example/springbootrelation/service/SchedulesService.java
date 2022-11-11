package com.example.springbootrelation.service;

import com.example.springbootrelation.Models.Price;
import com.example.springbootrelation.Models.Schedules;
import com.example.springbootrelation.repository.SchedulesRepository;
import com.example.springbootrelation.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SchedulesService {

    @Autowired
    private SchedulesRepository schedulesRepository;
    @Autowired
    private PriceRepository priceRepository;

    public Schedules saveSchedules(Schedules schedules){
        return schedulesRepository.save(schedules);
    }

    public List<Schedules> getAllSchedules(){
        return schedulesRepository.findAll();
    }

    public Schedules addPriceToSchedules(Long schedulesId, Long priceId){
        Schedules schedules = schedulesRepository.findById(schedulesId).get();
        Price price = priceRepository.findById(priceId).get();

        schedules.setPrice(price);
        return schedulesRepository.save(schedules);
    }
}
