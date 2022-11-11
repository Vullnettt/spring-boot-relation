package com.example.springbootrelation.repository;

import com.example.springbootrelation.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);

    @Query("Select s From Student s Where s.email = ?1")
    Student getByEmail(String email);

    @Query("Select s From Student s Where s.age BETWEEN 18 AND 30")
    List<Student> getStudentBetween();

    @Query("Select s From Student s Where s.id <= 10")
    List<Student> getFirstTenStudent();

    @Query("Select s From Student s Where s.age = ?1")
    public List<Student> getStudentByAge(Integer age);

    @Query("Select s From Student s " +
            "Group By s.firstName, s.age " +
            "Order By s.firstName, s.age")
    public List<Student> orderStudentAlphabetically();

    @Query("Select s From Student s Where s.gender Not In('M', 'F')")
    List<Student> getIncorrectStudentGender();

    @Query("Select s From Student s Where s.gender = 'M'")
    List<Student> getMaleStudent();

    @Query("Select s From Student s Where s.gender = 'F'")
    List<Student> getFemaleStudent();

//    @Query("Select s.email, p.firstName From Student As s Inner Join Professor As p On s.professors = p.id")
}
