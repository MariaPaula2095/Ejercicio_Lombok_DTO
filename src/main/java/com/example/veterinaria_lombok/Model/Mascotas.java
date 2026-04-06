package com.example.veterinaria_lombok.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mascotas")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie; // perro, gato, etc
    private String raza;
    private int edad;
    private Double peso;
    private String propietario; // nombre del dueño
}
