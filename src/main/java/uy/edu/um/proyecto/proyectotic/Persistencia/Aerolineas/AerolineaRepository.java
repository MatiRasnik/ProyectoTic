package uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AerolineaRepository extends JpaRepository<Aerolineas, Long> {
    // @Query("SELECT a FROM aerolineas a WHERE a.codigo= ?1")
    Aerolineas findByCodigo(String code);
}
