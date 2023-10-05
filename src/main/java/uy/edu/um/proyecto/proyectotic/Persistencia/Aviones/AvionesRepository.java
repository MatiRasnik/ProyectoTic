package uy.edu.um.proyecto.proyectotic.Persistencia.Aviones;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AvionesRepository extends JpaRepository<Aviones,Long>{
    Aviones findByMatricula(String matricula);
}
