package uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import java.util.List;


public interface AeropuertoRepository extends JpaRepository<Aeropuertos,Long>{
    Aeropuertos findByCodigoIATA(String code);
    List<Aeropuertos> findByPais(String pais);
    
}
