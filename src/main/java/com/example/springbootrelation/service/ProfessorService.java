package com.example.springbootrelation.service;

import com.example.springbootrelation.Models.Schedules;
import com.example.springbootrelation.Models.Professor;
import com.example.springbootrelation.repository.SchedulesRepository;
import com.example.springbootrelation.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SchedulesRepository schedulesRepository;

    public Professor saveProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    public Professor addSchedulesToProfessor(Long professorId, Long schedulesId){
        Schedules schedules = schedulesRepository.findById(schedulesId).get();
        Professor professor = professorRepository.findById(professorId).get();

        professor.getSchedules().add(schedules);
        return professorRepository.save(professor);
    }
}
