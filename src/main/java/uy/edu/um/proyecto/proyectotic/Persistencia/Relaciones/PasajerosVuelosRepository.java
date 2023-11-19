package uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajerosVuelosRepository  extends JpaRepository<PasajerosVuelos,PasajerosVuelosId> {
    List<String> findByIdPasaporte(String pasaporte);
    List<String> findByIdCodigoVuelo(String codigoVuelo);
    PasajerosVuelos findByIdPasaporteAndIdCodigoVuelo(String pasaporte, String codigoVuelo);
    
}
