package uy.edu.um.proyecto.proyectotic.Servicios;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.Pilotos;
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

    public void crearVuelo(String aerolinea, String matricula,String aeropuertoSalida, String aeropuertoLlegada, LocalDate fechaSalida, String horaSalida, LocalDate fechaLlegada, String horaLlegada) throws Exception{
        if(avionesRepositorio.findByMatricula(matricula)==null || aeropuertoRepository.findByCodigoIATA(aeropuertoSalida)==null || aeropuertoRepository.findByCodigoIATA(aeropuertoLlegada)==null){
            System.out.println("NoEXISTE ALGO");
            throw new Exception();
        } else{
            System.out.println("PROBLEMA");
            Vuelos vuelo=new Vuelos();
            vuelo.setMatricula(matricula);
            vuelo.setAerolinea(aerolinea);
            vuelo.setAereopuertoSalida(aeropuertoSalida);
            vuelo.setAeropuertoLlegada(aeropuertoLlegada);
            vuelo.setFechaSalida(fechaSalida);
            vuelo.setHoraSalida(horaSalida);
            vuelo.setFechaLlegada(fechaLlegada);
            vuelo.setHoraLlegada(horaLlegada);
            vuelo.setEstadoAceptacionLlegada(false);
            vuelo.setEstadoAceptacionSalida(false);
            vuelo.setEstadoVuelo("Esperando aceptacion");
            Vuelos savedVuelo = vuelosRepository.save(vuelo);
            
            Long numero=savedVuelo.getNumber();
            String num=numero.toString();
            savedVuelo.setCodigoVuelo(aerolinea+num);
            vuelosRepository.save(savedVuelo);
            
        }
    }
    
}
