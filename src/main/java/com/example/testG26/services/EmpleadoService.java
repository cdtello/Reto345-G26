package com.example.testG26.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testG26.entities.Empleado;
import com.example.testG26.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // METODOS PARA CRUD
    public List<Empleado> getListEmpleados(){
        return this.empleadoRepository.findAll();
    }

    public Empleado getEmpleado(int id){
        if (this.empleadoRepository.findById(id).isEmpty()){
            return null;
        }else{
            return this.empleadoRepository.findById(id).get();
        }
    }

    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }

    public void eliminarEmpleado(int id){
        if (!this.empleadoRepository.findById(id).isEmpty()){
            this.empleadoRepository.deleteById(id);
        }
    }

    public void actualizarEmpleado(int id, Empleado empleado){
        if (!this.empleadoRepository.findById(id).isEmpty()){
            Empleado empleadoDB = this.empleadoRepository.findById(id).get();

            if(empleado.getNombre() != null){
                empleadoDB.setNombre(empleado.getNombre());
            }
            if(empleado.getApellido() != null){
                empleadoDB.setApellido(empleado.getApellido());
            }
            if(empleado.getEdad() != null){
                empleadoDB.setEdad(empleado.getEdad());
            }
            if(empleado.getCorreoEmpleado() != null){
                empleadoDB.setCorreoEmpleado(empleado.getCorreoEmpleado());
            }
            empleadoDB.setUpdatedAt( new Date());

            this.empleadoRepository.save(empleadoDB);
        }
    }
    
}
