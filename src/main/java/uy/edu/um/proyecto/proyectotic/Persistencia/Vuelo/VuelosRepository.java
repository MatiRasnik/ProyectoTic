package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface VuelosRepository extends JpaRepository<Vuelos,Long>{
    Vuelos findByCodigoVuelo(String codigoVuelo);
    List<Vuelos> findByAeropuertoLlegada(String aeropuertoLlegada);
    List<Vuelos> findByAeropuertoSalida(String aeropuertoLlegada);
    
    
}
