package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.profile.Association;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.AsociacionTransporte;
import uy.edu.um.VuelosDTO;
import uy.edu.um.AerolineaTransporte;
import uy.edu.um.AerolineasDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.AerolineasMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Servicios.AerolineasService;

@RestController
public class AerolineasRestService {
    @Autowired
    private AerolineasMapper aerolineasMapper;
    @Autowired
    private AerolineasService aerolineasService;
    @Autowired
    private AerolineaRepository aerolineaRepository;
    @Autowired
    private AerolineasAeropuertosRepository aerolineasAeropuertosRepository;

    @PostMapping("/crearAerolineas")
    public void crearAerolineas(@RequestBody AerolineaTransporte aerolineaTransporte) throws Exception {
        Aerolineas aerolinea = aerolineasMapper.toAerolineas(aerolineaTransporte.getAerolineasDTO());
        aerolineasService.crearAereolinea(aerolinea, aerolineaTransporte.getEmail(),
                aerolineaTransporte.getContrasena());

    }

    @PostMapping("/eliminarAerolineas")
    public void eliminarAerolineas(@RequestBody String id) throws Exception {
        aerolineasService.eliminarAerolinea(id);
    }

    @GetMapping("/getAeropuertosAsociados/{id}")
    public List<String> getAeropuertos(@PathVariable("id") String aerolinea) {
        List<AerolineasAeropuertos> aerolineasAeropuertos = aerolineasAeropuertosRepository
                .findByIdAerolinea(aerolinea);
        List<String> aeropuertos = new ArrayList<>();

        for (AerolineasAeropuertos combo : aerolineasAeropuertos) {
            aeropuertos.add(combo.getId().getAeropuerto());

        }

        return aeropuertos;

    }

    @GetMapping("/getAerolineas")
    public List<AerolineasDTO> getAerolineas() {
        List<Aerolineas> aerolineas = aerolineaRepository.findAll();
        List<AerolineasDTO> aerolineasDTOs = new ArrayList<>();
        for (Aerolineas combo : aerolineas) {
            aerolineasDTOs.add(aerolineasMapper.toDTO(combo));
        }
        return aerolineasDTOs;
    }

    @GetMapping("/getAerolineasAeropuerto/{empresa}")
    public List<String> getAerolineasAeropuerto(@PathVariable("empresa") String empresa) {
        List<AerolineasAeropuertos> aerolineasAerolineas = aerolineasAeropuertosRepository.findByIdAeropuerto(empresa);
        List<String> aerolineas = new ArrayList<>();

        for (AerolineasAeropuertos combo : aerolineasAerolineas) {
            aerolineas.add(combo.getId().getAeropuerto());

        }

        return aerolineas;

    }

}
