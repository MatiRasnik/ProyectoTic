package uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;

public interface AeropuertoRepository extends JpaRepository<Aeropuertos,Long>{
    Aeropuertos findByCodigo(String code);
}
