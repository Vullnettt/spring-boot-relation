package com.example.springbootrelation.repository;

import com.example.springbootrelation.Models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    Optional<Classes> findById(Long id);
}
