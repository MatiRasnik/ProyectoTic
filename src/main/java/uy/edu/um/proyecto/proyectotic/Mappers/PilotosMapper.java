package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;

import uy.edu.um.PilotosDTO;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.Pilotos;

@Component
public class PilotosMapper {
    public Pilotos toPilotos (PilotosDTO pilotosDTO){

        Pilotos pilotos = new Pilotos();
       
        pilotos.setLicenciaPiloto(pilotosDTO.getLicenciaPiloto());
        pilotos.setEmail(pilotosDTO.getEmail());

        
        return pilotos;
    }

    public PilotosDTO toDTO (Pilotos pilotos){

        PilotosDTO pilotosDTO = new PilotosDTO();
       
        pilotosDTO.setLicenciaPiloto(pilotos.getLicenciaPiloto());
        pilotosDTO.setEmail(pilotos.getEmail());

        
        return pilotosDTO;
    }
}
