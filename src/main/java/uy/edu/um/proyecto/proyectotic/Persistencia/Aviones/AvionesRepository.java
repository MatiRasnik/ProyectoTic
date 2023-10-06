package uy.edu.um.proyecto.proyectotic.Persistencia.Aviones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;

public interface AvionesRepository extends JpaRepository<Aviones,Long>{
    @Query("SELECT a FROM Aviones a WHERE a.matricula = ?1")
    Aviones findByMatricula(String matricula);
}
