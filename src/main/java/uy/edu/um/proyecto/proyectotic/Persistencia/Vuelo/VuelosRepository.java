package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VuelosRepository extends JpaRepository<Vuelos, Long> {
    Vuelos findByCodigoVuelo(String codigoVuelo);

    List<Vuelos> findByAeropuertoLlegada(String aeropuertoLlegada);

    List<Vuelos> findByAeropuertoSalida(String aeropuertoLlegada);

    List<Vuelos> findByAerolinea(String nombreEmpresa);

    @Query("SELECT v FROM Vuelos v WHERE (v.aeropuertoLlegada =?1 AND v.estadoAceptacionLlegada = FALSE) OR (v.aeropuertoSalida =?1 AND v.estadoAceptacionSalida = FALSE)")
    List<Vuelos> findVuelos(String email);

    @Query("SELECT v FROM Vuelos v WHERE v.aeropuertoLlegada =?1 OR v.aeropuertoSalida =?1")
    List<Vuelos> findVuelosAeropuerto(String nombreEmpresa);
}
