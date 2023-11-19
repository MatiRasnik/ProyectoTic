package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VuelosRepository extends JpaRepository<Vuelos, Long> {
    Vuelos findByCodigoVuelo(String codigoVuelo);

    List<Vuelos> findByAeropuertoLlegada(String aeropuertoLlegada);

    List<Vuelos> findByAeropuertoSalida(String aeropuertoLlegada);

    List<Vuelos> findByAerolinea(String nombreEmpresa);

    @Query("SELECT v FROM Vuelos v WHERE (v.aeropuertoLlegada =?1 AND v.estadoAceptacionLlegada = null) OR (v.aeropuertoSalida =?1 AND v.estadoAceptacionSalida = null)")
    List<Vuelos> findVuelos(String email);

    @Query("SELECT v FROM Vuelos v WHERE v.aeropuertoLlegada =?1 OR v.aeropuertoSalida =?1")
    List<Vuelos> findVuelosAeropuerto(String nombreEmpresa);

    @Query("SELECT v FROM Vuelos v WHERE v.aerolinea =?1 AND v.estadoAceptacionSalida = TRUE AND v.estadoAceptacionLlegada = TRUE ")
    List<Vuelos> findVuelosAerolineaAceptados(String nombreEmpresa);

    @Query("SELECT v FROM Vuelos v WHERE v.aeropuertoLlegada =?1 AND v.estadoAceptacionLlegada = TRUE AND v.aeropuertoSalida =?2 AND v.estadoAceptacionSalida = TRUE")
    List<Vuelos> findAeropuertoLlegadaAndAeropuertoSalida(String aeropuertoLlegada, String aeropuertoSalida);
}
