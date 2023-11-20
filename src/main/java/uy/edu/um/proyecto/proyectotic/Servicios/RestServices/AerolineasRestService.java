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
import uy.edu.um.AvionesDTO;
import uy.edu.um.PasajerosVuelosT;
import uy.edu.um.UsuariosDTO;
import uy.edu.um.VuelosDTO;
import uy.edu.um.AerolineaTransporte;
import uy.edu.um.AerolineasDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.AerolineasMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.Pilotos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.UsuariosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Servicios.AerolineasService;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.PilotosRepository;

@RestController
public class AerolineasRestService {
    @Autowired
    private AerolineasMapper aerolineasMapper;
    @Autowired
    private AerolineasService aerolineasService;
    @Autowired
    private AerolineaRepository aerolineaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PilotosRepository pilotoRespository;
    @Autowired
    private AvionesRepository avionesRepository;
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
    public List<AerolineasDTO> getAerolineasAeropuerto(@PathVariable("empresa") String empresa) {
        List<AerolineasAeropuertos> aerolineasAerolineas = aerolineasAeropuertosRepository.findByIdAeropuerto(empresa);
        List<AerolineasDTO> aerolineasDTOs = new ArrayList<>();

        for (AerolineasAeropuertos combo : aerolineasAerolineas) {
            Aerolineas aerolinea = aerolineaRepository.findByCodigo(combo.getId().getAerolinea());
            aerolineasDTOs.add(aerolineasMapper.toDTO(aerolinea));
        }
        return aerolineasDTOs;
    }

    @PostMapping("/asignarVueloPasajero")
    public void asignarVueloPasajero(@RequestBody PasajerosVuelosT pasajerosVuelosT) throws Exception {
        aerolineasService.asignarVueloPasajero(pasajerosVuelosT.getCodigoVuelo(), pasajerosVuelosT.getPasaporte());
    }

    @PostMapping("/vuelosComprados")
    public List<VuelosDTO> vuelosComprados(@RequestBody String pasaporte) throws Exception {
        return aerolineasService.vuelosPasajero(pasaporte);
    }

    @GetMapping("/getPilotos/{empresa}")
    public List<String> getPilotos(@PathVariable("empresa") String empresa) {
        List<Usuarios> pilotosAerolinea = usuariosRepository.findPilotos(empresa);
        List<String> pilotos = new ArrayList<>();
        for (Usuarios combo : pilotosAerolinea) {
            Pilotos piloto = pilotoRespository.findByEmail(combo.getEmail());
            pilotos.add(piloto.getLicenciaPiloto());
        }
        return pilotos;
    }

    @GetMapping("/getListaAviones/{empresa}")
    public List<String> getListaAviones(@PathVariable("empresa") String empresa) {
        List<Aviones> aviones = avionesRepository.findByEmpresa(empresa);
        List<String> listaAviones = new ArrayList<>();
        for (Aviones combo : aviones) {
            listaAviones.add(combo.getMatricula());
        }
        return listaAviones;
    }

}
