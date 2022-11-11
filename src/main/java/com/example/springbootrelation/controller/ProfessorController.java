package com.example.springbootrelation.controller;

import com.example.springbootrelation.Models.Professor;
import com.example.springbootrelation.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/addProfessor")
    public Professor saveProfessor(@RequestBody Professor professor){
        return professorService.saveProfessor(professor);
    }

    @GetMapping("/getAllProfessors")
    private List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @PutMapping("/professor/{professorId}/to/schedule/{schedulesId}")
    public Professor addSchedulesToProfessor(@PathVariable Long professorId, @PathVariable Long schedulesId){
        return professorService.addSchedulesToProfessor(professorId, schedulesId);
    }
}
