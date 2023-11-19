package uy.edu.um.proyecto.proyectotic.Servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
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

        if(avionesRepositorio.findByMatricula(vuelo.getMatricula())==null || aeropuertoRepository.findByCodigoIATA(vuelo.getAeropuertoSalida())==null || aeropuertoRepository.findByCodigoIATA(vuelo.getAeropuertoLlegada())==null || vuelosRepository.findByCodigoVuelo(vuelo.getCodigoVuelo())!=null){
            throw new Exception();
        } else{
            String horaSalida= vuelo.getHoraSalida();
            String horaLlegada=vuelo.getHoraSalida();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date timeSalida = dateFormat.parse(horaSalida);
            Date timeLlegada = dateFormat.parse(horaLlegada);
            String[] words = vuelo.getCodigoVuelo().split("-",2);
            int intValue = Integer.parseInt(words[1]);
            if(words[0].compareTo(vuelo.getAerolinea())!=0){

                throw new Exception();
            }
            vuelosRepository.save(vuelo);
            
        }
    }

    public List<Vuelos> vuelosDisponibles(String salida, String llegada){
        List<Aeropuertos> aeropuertosSalida=aeropuertoRepository.findByPais(salida);
        List<Aeropuertos> aeropuertosLlegada=aeropuertoRepository.findByPais(llegada);
        List<String> iataSalida=new ArrayList<>();
        List<String> iataLlegada=new ArrayList<>();
        List<Vuelos> vuelosTotales=new ArrayList<>();
        for (Aeropuertos iata : aeropuertosSalida) {
            iataSalida.add(iata.getCodigoIATA());
        }
        for (Aeropuertos iata : aeropuertosLlegada) {
            iataLlegada.add(iata.getCodigoIATA());
        }
        for (String salidaIata : iataLlegada) {
            for (String llegadaIata : iataSalida) {
                vuelosTotales.addAll(vuelosRepository.findByAeropuertoLlegadaAndAeropuertoSalida(salidaIata, llegadaIata));
                
            }
            
        }
        return vuelosTotales;
    }
    
}
