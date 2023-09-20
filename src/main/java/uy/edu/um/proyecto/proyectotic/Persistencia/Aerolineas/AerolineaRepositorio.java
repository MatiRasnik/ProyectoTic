package uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.pruebainicial.modelos.Aerolinea;

public interface AerolineaRepositorio extends JpaRepository<Aerolinea,Long>{
}
