package com.example.springbootrelation.service;

import com.example.springbootrelation.Models.Classes;
import com.example.springbootrelation.Models.Professor;
import com.example.springbootrelation.Models.Student;
import com.example.springbootrelation.repository.ClassesRepository;
import com.example.springbootrelation.repository.ProfessorRepository;
import com.example.springbootrelation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ClassesRepository classesRepository;

    public Student saveStudent(Student student){
        if(studentRepository.getByEmail(student.getEmail()) != null) throw new RuntimeException("email already exist");
        if(student.getAge() < 18) throw new RuntimeException("you are under age");
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student addClassToStudent(Long studentId, Long classId){
        Student student = studentRepository.findById(studentId).get();
        Classes classes = classesRepository.findById(classId).get();

        student.setClasses(classes);
        return studentRepository.save(student);
    }

    public Student addProfessorToStudent(Long studentId, Long professorId){
        Student student = studentRepository.findById(studentId).get();
        Professor professor = professorRepository.findById(professorId).get();

        student.getProfessors().add(professor);
        return studentRepository.save(student);
    }

    public List<Student> getStudentBetween(){
        return studentRepository.getStudentBetween();
    }

    public List<Student> getFirstTenStudent(){
        return studentRepository.getFirstTenStudent();
    }

    public List<Student> getStudentByAge(Integer age){
        return studentRepository.getStudentByAge(age);
    }

    public List<Student> orderStudentAlphabetically(){
        return studentRepository.orderStudentAlphabetically();
    }

    public List<Student> getIncorrectStudentGender(){
        return studentRepository.getIncorrectStudentGender();
    }

    public List<Student> getMaleStudent(){
        return studentRepository.getMaleStudent();
    }

    public List<Student> getFemaleStudent(){
        return studentRepository.getFemaleStudent();
    }
}
