package com.example.springbootrelation.service;

import com.example.springbootrelation.Models.Classes;
import com.example.springbootrelation.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    public Classes saveClass(Classes classes){
        return classesRepository.save(classes);
    }

    public List<Classes> findAllClasses() {
        return classesRepository.findAll();
    }
}
