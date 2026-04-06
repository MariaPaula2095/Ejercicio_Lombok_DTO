package com.example.veterinaria_lombok.Service;

import com.example.veterinaria_lombok.DTO.MascotaDTO;
import com.example.veterinaria_lombok.Model.Mascotas;
import com.example.veterinaria_lombok.Repository.MascotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
// Marca esta clase como componente de servicio en Spring
    public class MascotaServiceImp implements MascotaService {
// Implementa la interfaz del servicio de mascotas

        private final MascotaRepository mascotaRepository;
        // Declara el repositorio para interactuar con la BD

        // Inyección por constructor (correcto)
        public MascotaServiceImp(MascotaRepository mascotaRepository) {
            // Constructor que recibe el repositorio
            this.mascotaRepository = mascotaRepository;
            // Asigna el repositorio a la variable interna
        }

        // LISTAR
        @Override
        // Indica que implementa un método de la interfaz
        public List<MascotaDTO> listar() {
            // Método para obtener todas las mascotas
            return mascotaRepository.findAll()
                    // Consulta todas las mascotas en la BD
                    .stream()
                    // Convierte la lista en un flujo de datos
                    .map(this::convertirA_DTO)
                    // Convierte cada entidad a DTO
                    .collect(Collectors.toList());
            // Convierte el resultado nuevamente en lista
        }

        // GUARDAR
        @Override
        // Implementa el método guardar
        public MascotaDTO guardar(MascotaDTO dto) {
            // Recibe los datos de la mascota en formato DTO
            Mascotas mascota = convertirA_Entity(dto);
            // Convierte el DTO a entidad
            Mascotas guardada = mascotaRepository.save(mascota);
            // Guarda la entidad en la BD
            return convertirA_DTO(guardada);
            // Retorna la entidad guardada convertida a DTO
        }

        // ELIMINAR
        @Override
        // Implementa el método eliminar
        public void eliminar(Long id) {
            // Recibe el ID de la mascota a eliminar
            mascotaRepository.deleteById(id);
            // Elimina la mascota de la BD por su ID
        }

        // ACTUALIZAR
        @Override
        // Implementa el método actualizar
        public MascotaDTO actualizar(Long id, MascotaDTO dto) {

            Mascotas existe = mascotaRepository.findById(id)
                    // Busca la mascota en la BD por ID
                    .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
            // Lanza error si no existe

            // Actualizar campos
            existe.setNombre(dto.getNombre());
            // Actualiza el nombre
            existe.setEspecie(dto.getEspecie());
            // Actualiza la especie
            existe.setRaza(dto.getRaza());
            // Actualiza la raza
            existe.setEdad(dto.getEdad());
            // Actualiza la edad
            existe.setPeso(dto.getPeso());
            // Actualiza el peso
            existe.setPropietario(dto.getPropietario());
            // Actualiza el propietario

            Mascotas actualizada = mascotaRepository.save(existe);
            // Guarda los cambios en la BD

            return convertirA_DTO(actualizada);
            // Retorna la mascota actualizada como DTO
        }

        //  =========================
        // CONVERSIONES
        //  =========================

        private MascotaDTO convertirA_DTO(Mascotas mascota) {
            // Convierte una entidad Mascotas a DTO
            return new MascotaDTO(
                    mascota.getId(),
                    // Asigna el ID
                    mascota.getNombre(),
                    // Asigna el nombre
                    mascota.getEspecie(),
                    // Asigna la especie
                    mascota.getRaza(),
                    // Asigna la raza
                    mascota.getEdad(),
                    // Asigna la edad
                    mascota.getPeso(),
                    // Asigna el peso
                    mascota.getPropietario()
                    // Asigna el propietario
            );
        }

        private Mascotas convertirA_Entity(MascotaDTO dto) {
            // Convierte un DTO a entidad Mascotas
            return new Mascotas(
                    dto.getId(),
                    // Asigna el ID
                    dto.getNombre(),
                    // Asigna el nombre
                    dto.getEspecie(),
                    // Asigna la especie
                    dto.getRaza(),
                    // Asigna la raza
                    dto.getEdad(),
                    // Asigna la edad
                    dto.getPeso(),
                    // Asigna el peso
                    dto.getPropietario()
                    // Asigna el propietario
            );
        }
    }