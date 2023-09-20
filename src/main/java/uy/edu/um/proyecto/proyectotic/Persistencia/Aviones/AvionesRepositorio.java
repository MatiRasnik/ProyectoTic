package uy.edu.um.proyecto.proyectotic.Persistencia.Aviones;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.pruebainicial.modelos.Aviones;
public interface AvionesRepositorio extends JpaRepository<Aviones,Long>{
}
