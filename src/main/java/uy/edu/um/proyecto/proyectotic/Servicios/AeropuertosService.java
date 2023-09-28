package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;


@Service
public class AeropuertosService {


    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    

    public void crearAeropuerto(String mail, String contrasena, String pais, String codigo, String nombre) {
        if(aeropuertoRepository.findByCodigo(codigo)==null){
            Aeropuertos aeropuerto = new Aeropuertos();
            aeropuerto.setCodigo(codigo);
            aeropuerto.setNombre(nombre);
            aeropuerto.setPais(pais);
            aeropuertoRepository.save(aeropuerto);
        } else {
            System.out.println("Error");
        }
    }
}
