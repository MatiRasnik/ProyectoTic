package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;

import uy.edu.um.AerolineasDTO;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;

@Component
public class AerolineasMapper {
    public Aerolineas toAerolineas(AerolineasDTO aerolineaDTO){

       Aerolineas aerolinea = new Aerolineas();
       
        aerolinea.setNombre(aerolineaDTO.getNombre());
        aerolinea.setSedePrincipal(aerolineaDTO.getSedePrincipal());
        aerolinea.setContacto(aerolineaDTO.getContacto());
        aerolinea.setCodigo(aerolineaDTO.getCodigo());
        aerolinea.setId(aerolineaDTO.getId());
        
        return aerolinea;
    }

    public AerolineasDTO toDTO(Aerolineas aerolinea){

        AerolineasDTO aerolineaDTO = new AerolineasDTO();
       
        aerolineaDTO.setNombre(aerolinea.getNombre());
        aerolineaDTO.setSedePrincipal(aerolinea.getSedePrincipal());
        aerolineaDTO.setContacto(aerolinea.getContacto());
        aerolineaDTO.setCodigo(aerolinea.getCodigo());
        aerolineaDTO.setId(aerolinea.getId());

        return aerolineaDTO;
    }

}
