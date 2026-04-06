package com.example.veterinaria_lombok.Repository;

import com.example.veterinaria_lombok.Model.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
//SE VA A HACER UNA HERENCIA JPA REPOSITORY
    public interface MascotaRepository extends JpaRepository<Mascotas, Long> {

    //SE PROGRAMA CONSULTAS A A LA BASE DE DATOS
}
