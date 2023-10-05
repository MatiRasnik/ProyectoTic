package uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotosRepository extends JpaRepository<Pilotos,String> {
    public Pilotos findByLicenciaPiloto(String licencia);
    
}
