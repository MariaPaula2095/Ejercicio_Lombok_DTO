package com.example.veterinaria_lombok.Service;
import com.example.veterinaria_lombok.DTO.MascotaDTO;
import com.example.veterinaria_lombok.Model.Mascotas;

import java.util.List;

public interface MascotaService {

    List<MascotaDTO> listar();

    MascotaDTO guardar(MascotaDTO mascota);

    void eliminar(Long id);

    MascotaDTO actualizar(Long id, MascotaDTO mascota);
}
