package com.example.springbootrelation.controller;

import com.example.springbootrelation.Models.Price;
import com.example.springbootrelation.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/addPrice")
    public Price savePrice(@RequestBody Price price){
        return priceService.savePrice(price);
    }

    @GetMapping("/getAllPrices")
    public List<Price> getAllPrice(){
        return priceService.getAllPrices();
    }
}
