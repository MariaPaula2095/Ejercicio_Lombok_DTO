package com.example.veterinaria_lombok.Controller;

import com.example.veterinaria_lombok.DTO.MascotaDTO;
import com.example.veterinaria_lombok.Service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas") // ruta base
public class MascotaController {

    private final MascotaService mascotaServiceImp;

    // Inyección por constructor (solo interfaz)
    public MascotaController(MascotaService mascotaService) {
        this.mascotaServiceImp = mascotaService;
    }

    // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<List<MascotaDTO>> listar() {
        List<MascotaDTO> mascotas = mascotaServiceImp.listar();
        return ResponseEntity.ok(mascotas); // 200 OK
    }

    // GUARDAR
    @PostMapping("/guardar")
    public ResponseEntity<MascotaDTO> guardar(@RequestBody MascotaDTO dto) {
        MascotaDTO guardada = mascotaServiceImp.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada); // 201 CREATED
    }

    // ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaServiceImp.eliminar(id);
        return ResponseEntity.noContent().build(); // 204 NO CONTENT
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MascotaDTO> actualizar(@PathVariable Long id, @RequestBody MascotaDTO dto) {
        MascotaDTO actualizada = mascotaServiceImp.actualizar(id, dto);
        return ResponseEntity.ok(actualizada); // 200 OK
    }
}
