package com.example.veterinaria_lombok.DTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Double peso;
    private String propietario;
}
