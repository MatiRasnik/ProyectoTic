package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;

@Component
public class AeropuertosMapper {
    public Aeropuertos toAeropuerto (AeropuertosDTO aeropuertosDTO){

        Aeropuertos aeropuerto = new Aeropuertos();
       /*
       aeropuerto.setNombre(aeropuertosDTO.getNombre());
       aeropuerto.setPais(aeropuertosDTO.getPais());
       aeropuerto.setCodigoIATA(aeropuertosDTO.getCodigoIATAo());
       aeropuerto.setCantidadPuertas(aeropuertosDTO.getCantidadPuertas());
       aeropuerto.setId(aeropuertosDTO.getId());
       aeropuerto.setCantidadMangas(aeropuertosDTO.getCantidadMangas());
       aeropuerto.setCantidadPuestos(aeropuertosDTO.getCantidadPuestos());
        */
        return aeropuerto;
    }

    public AeropuertosDTO toDTO (Aeropuertos aeropuertos){

        AeropuertosDTO aeropuertosDTO = new AeropuertosDTO();
       /*
       aeropuertosDTO.setNombre(aeropuertos.getNombre());
       aeropuertosDTO.setPais(aeropuertos.getPais());
       aeropuertosDTO.setCodigoIATA(aeropuertos.getCodigoIATAo());
       aeropuertosDTO.setCantidadPuertas(aeropuertos.getCantidadPuertas());
       aeropuertosDTO.setId(aeropuertos.getId());
       aeropuertosDTO.setCantidadMangas(aeropuertos.getCantidadMangas());
       aeropuertosDTO.setCantidadPuestos(aeropuertos.getCantidadPuestos());
        */
        return aeropuertosDTO;
    }
}
