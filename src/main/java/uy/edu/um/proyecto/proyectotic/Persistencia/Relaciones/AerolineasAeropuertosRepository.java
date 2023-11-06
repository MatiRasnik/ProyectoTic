package uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineasAeropuertosRepository extends JpaRepository<AerolineasAeropuertos,AerolineasAeropuertosId>{
    List<AerolineasAeropuertos> findByIdAerolinea(String iataAerolinea);
    List<AerolineasAeropuertos> findByIdAeropuerto(String iataAeropuerto);
    AerolineasAeropuertos findByIdAerolineaAndIdAeropuerto(String iataAerolinea,String iataAeropuerto);
    
  
}
