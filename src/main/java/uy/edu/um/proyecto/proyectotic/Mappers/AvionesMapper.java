package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;

@Component
public class AvionesMapper {
    public Aviones toAviones (AvionesDTO avionesDTO){

        Aviones aviones = new Aviones();
       /*
       aviones.setMatricula(avionesDTO.getMatricula());
       aviones.setModelo(avionesDTO.getModelo());
       aviones.setCantidadPasajeros(avionesDTO.getCantidadPasajeros());
       aviones.setCapacidadCarga(avionesDTO.getCapacidadCarga());
       aviones.setDistanciaDeDespegue(avionesDTO.getDistanciaDeDespegue());
       aviones.setDistancaVuelo(avionesDTO.getDistancaVuelo());
       aviones.setEmpresa(avionesDTO.getEmpresa());
        */
        return aviones;
    }

    public AvionesDTO toDTO (Aviones aviones){

        AvionesDTO avionesDTO = new AvionesDTO();
       /*
       avionesDTO.setMatricula(aviones.getMatricula());
       avionesDTO.setModelo(aviones.getModelo());
       avionesDTO.setCantidadPasajeros(aviones.getCantidadPasajeros());
       avionesDTO.setCapacidadCarga(aviones.getCapacidadCarga());
       avionesDTO.setDistanciaDeDespegue(aviones.getDistanciaDeDespegue());
       avionesDTO.setDistancaVuelo(aviones.getDistancaVuelo());
       avionesDTO.setEmpresa(aviones.getEmpresa());
        */
        return avionesDTO;
    }
}
