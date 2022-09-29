package com.example.testG26.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testG26.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Integer> {
    
}
