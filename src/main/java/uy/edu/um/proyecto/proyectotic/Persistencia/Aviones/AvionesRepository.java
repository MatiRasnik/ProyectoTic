package uy.edu.um.proyecto.proyectotic.Persistencia.Aviones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvionesRepository extends JpaRepository<Aviones, String> {
    Aviones findByMatricula(String matricula);

    List<Aviones> findByEmpresa(String nombreEmpresa);
}
