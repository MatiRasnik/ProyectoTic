package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;

@Service
public class AerolineasService {
    @Autowired
    private AerolineaRepository aerolineaRepositorio;
    
    public void crearAereolinea(String nombre,String codigo,String contacto,String ubicacionSede){
        if(aerolineaRepositorio.findByCodigo(codigo)==null){
            Aerolineas aerolinea=new Aerolineas();
            aerolinea.setCodigo(codigo);
            aerolinea.setNombre(nombre);
            aerolinea.setContacto(contacto);
            aerolinea.setSedePrincipal(ubicacionSede);
            aerolineaRepositorio.save(aerolinea);
        } else {
            System.out.println("Error");
        }
    }

}
