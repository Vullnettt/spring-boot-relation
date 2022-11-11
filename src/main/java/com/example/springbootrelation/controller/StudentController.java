package com.example.springbootrelation.controller;

import com.example.springbootrelation.Models.Student;
import com.example.springbootrelation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PutMapping("/student/{studentId}/to/class/{classId}")
    public Student addClassToStudent(@PathVariable Long studentId, @PathVariable Long classId){
        return studentService.addClassToStudent(studentId, classId);
    }

    @PutMapping("/student/{studentId}/to/professor/{professorId}")
    public Student addProfessorToStudent(@PathVariable Long studentId, @PathVariable Long professorId){
        return studentService.addProfessorToStudent(studentId, professorId);
    }

    @GetMapping("/getStudentBetween")
    public List<Student> getStudentBetween(){
        return studentService.getStudentBetween();
    }

    @GetMapping("/getFirstTenStudent")
    public List<Student> getFirstTenStudent(){
        return studentService.getFirstTenStudent();
    }

    @GetMapping("/getStudentByAge/{age}")
    public List<Student> getStudentByAge(@PathVariable Integer age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping("/orderStudentAlphabetically")
    public List<Student> orderStudentAlphabetically(){
        return studentService.orderStudentAlphabetically();
    }

    @GetMapping("/getIncorrectStudentGender")
    public List<Student> getIncorrectStudentGender(){
        return studentService.getIncorrectStudentGender();
    }

    @GetMapping("/getMaleStudent")
    public List<Student> getMaleStudent(){
        return studentService.getMaleStudent();
    }

    @GetMapping("/getFemaleStudent")
    public List<Student> getFemaleStudent(){
        return studentService.getFemaleStudent();
    }
}
