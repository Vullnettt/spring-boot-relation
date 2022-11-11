package com.example.springbootrelation.controller;

import com.example.springbootrelation.Models.Classes;
import com.example.springbootrelation.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @PostMapping("/addClass")
    public Classes saveClass(@RequestBody Classes classes){
        return classesService.saveClass(classes);
    }

    @GetMapping("/getAllClasses")
    public List<Classes> findAllClasses(){
        return classesService.findAllClasses();
    }
}
