package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.PilotosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.VuelosRepository;

@Service
public class VuelosService {
    @Autowired
    AvionesRepository avionesRepositorio;
    @Autowired
    AeropuertoRepository aeropuertoRepository;
    @Autowired
    PilotosRepository pilotosRepository;
    @Autowired
    VuelosRepository vuelosRepository;

    public void crearVuelo(Vuelos vuelo) throws Exception{
        if(avionesRepositorio.findByMatricula(vuelo.getMatricula())==null || aeropuertoRepository.findByCodigoIATA(vuelo.getAeropuertoSalida())==null || aeropuertoRepository.findByCodigoIATA(vuelo.getAeropuertoLlegada())==null){
            throw new Exception();
        } else{

            Vuelos savedVuelo = vuelosRepository.save(vuelo);
            
            Long numero=savedVuelo.getNumber();
            String num=numero.toString();
            savedVuelo.setCodigoVuelo(vuelo.getAerolinea()+num);
            vuelosRepository.save(savedVuelo);
            
        }
    }
    
}
