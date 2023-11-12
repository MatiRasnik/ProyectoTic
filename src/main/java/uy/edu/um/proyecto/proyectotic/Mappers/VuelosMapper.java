package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;

import uy.edu.um.VuelosDTO;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;

@Component
public class VuelosMapper {

    public Vuelos toVuelos (VuelosDTO vuelosDTO){

        Vuelos vuelo = new Vuelos();
       
        vuelo.setCodigoVuelo(vuelosDTO.getCodigoVuelo());
        vuelo.setMatricula(vuelosDTO.getMatricula());
        vuelo.setAeropuertoSalida(vuelosDTO.getAeropuertoSalida());
        vuelo.setAeropuertoLlegada(vuelosDTO.getAeropuertoLlegada());
        vuelo.setEstadoAceptacionSalida(vuelosDTO.getEstadoAceptacionSalida());
        vuelo.setEstadoAceptacionLlegada(vuelosDTO.getEstadoAceptacionLlegada());
        vuelo.setEstadoVuelo(vuelosDTO.getEstadoVuelo());
        vuelo.setFechaSalida(vuelosDTO.getFechaSalida());
        vuelo.setHoraSalida(vuelosDTO.getHoraSalida());
        vuelo.setFechaLlegada(vuelosDTO.getFechaLlegada());
        vuelo.setHoraLlegada(vuelosDTO.getHoraLlegada());
        vuelo.setLicenciaPiloto(vuelosDTO.getLicenciaPiloto());
        vuelo.setNumber(vuelosDTO.getNumber());
        vuelo.setAerolinea(vuelosDTO.getAerolinea());
        vuelo.setPuertaLlegada(vuelosDTO.getPuertaLlegada());
        vuelo.setPuertaSalida(vuelosDTO.getPuertaSalida());
        vuelo.setPistaLlegada(vuelosDTO.getPistaLlegada());
        vuelo.setPistaSalida(vuelosDTO.getPistaSalida());

        
    
        return vuelo;
    }

    public VuelosDTO toDTO (Vuelos vuelo){

        VuelosDTO vuelosDTO = new VuelosDTO();
       
        vuelosDTO.setCodigoVuelo(vuelo.getCodigoVuelo());
        vuelosDTO.setAerolinea(vuelo.getAerolinea());
        vuelosDTO.setMatricula(vuelo.getMatricula());
        vuelosDTO.setAeropuertoSalida(vuelo.getAeropuertoSalida());
        vuelosDTO.setAeropuertoLlegada(vuelo.getAeropuertoLlegada());
        vuelosDTO.setEstadoAceptacionSalida(vuelo.getEstadoAceptacionSalida());
        vuelosDTO.setEstadoAceptacionLlegada(vuelo.getEstadoAceptacionLlegada());
        vuelosDTO.setEstadoVuelo(vuelo.getEstadoVuelo());
        vuelosDTO.setFechaSalida(vuelo.getFechaSalida());
        vuelosDTO.setHoraSalida(vuelo.getHoraSalida());
        vuelosDTO.setFechaLlegada(vuelo.getFechaLlegada());
        vuelosDTO.setHoraLlegada(vuelo.getHoraLlegada());
        vuelosDTO.setLicenciaPiloto(vuelo.getLicenciaPiloto());
        vuelosDTO.setNumber(vuelo.getNumber());
        vuelosDTO.setPuertaLlegada(vuelo.getPuertaLlegada());
        vuelosDTO.setPuertaSalida(vuelo.getPuertaSalida());
        vuelosDTO.setPistaSalida(vuelo.getPistaSalida());
        vuelosDTO.setPistaLlegada(vuelo.getPistaLlegada());
        return vuelosDTO;
    }
}
