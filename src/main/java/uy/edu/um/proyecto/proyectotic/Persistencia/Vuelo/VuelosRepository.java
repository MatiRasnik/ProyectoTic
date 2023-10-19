package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;


public interface VuelosRepository extends JpaRepository<Vuelos,String>{

    Vuelos findByNumber(Long number);
}
