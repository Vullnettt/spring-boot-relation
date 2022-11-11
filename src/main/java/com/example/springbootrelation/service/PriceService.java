package com.example.springbootrelation.service;

import com.example.springbootrelation.Models.Price;
import com.example.springbootrelation.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price savePrice(Price price){
        return priceRepository.save(price);
    }

    public List<Price> getAllPrices(){
        return priceRepository.findAll();
    }
}
