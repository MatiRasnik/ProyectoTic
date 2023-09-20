package uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.pruebainicial.modelos.Aeropuerto;
public interface AeropuertoRepositorio extends JpaRepository<Aeropuerto,Long>{
}
