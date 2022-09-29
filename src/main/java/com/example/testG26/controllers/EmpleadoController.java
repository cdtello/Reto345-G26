package com.example.testG26.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testG26.entities.Empleado;
import com.example.testG26.services.EmpleadoService;

@Service
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping("/test")
    public String getTest(){
        return "Hola test";
    }

    @GetMapping("/hola")
    public String getHola(){
        return "Hola hola";
    }

    @GetMapping("/mundo")
    public String getMundo(){
        return "mundo test";
    }

    @GetMapping("/adios")
    public String getAdios(){
        return "Adios test";
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getEmpleados(){
        return new ResponseEntity<List<Empleado>>(this.empleadoService.getListEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") int id){
        return new ResponseEntity<Empleado>(this.empleadoService.getEmpleado(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<Empleado>(this.empleadoService.crearEmpleado(empleado), HttpStatus.CREATED); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable("id") int id){
        this.empleadoService.actualizarEmpleado(id, empleado);
        return new ResponseEntity<String>("Empleado Actualizado", HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") int id){
        this.empleadoService.eliminarEmpleado(id);
        return new ResponseEntity<String>("Empleado Eliminado", HttpStatus.NO_CONTENT);
    }
}
