package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import uy.edu.um.AvionesDTO;
import uy.edu.um.OrigenDestino;
import uy.edu.um.VuelosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.VuelosMapper;
import uy.edu.um.proyecto.proyectotic.Servicios.VuelosService;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.VuelosRepository;

@RestController
public class VuelosRestService {
    @Autowired
    private VuelosMapper vuelosMapper;
    @Autowired
    private VuelosService vuelosService;
    @Autowired
    private VuelosRepository vuelosRepository;
    

    @PostMapping("/crearVuelo")
    public void crearVuelo(@RequestBody VuelosDTO vuelosDTO) throws Exception {

        Vuelos vuelo = vuelosMapper.toVuelos(vuelosDTO);
        vuelosService.crearVuelo(vuelo);
    }

    @GetMapping("/getVuelos/{empresa}")
    public List<VuelosDTO> getVuelos(@PathVariable("empresa") String nombreEmpresa) {

        List<Vuelos> vuelos = vuelosRepository.findVuelos(nombreEmpresa);
        List<VuelosDTO> vuelosDTOs = new ArrayList<>();
        for (Vuelos vuelo : vuelos) {
            vuelosDTOs.add(vuelosMapper.toDTO(vuelo));
        }
        return vuelosDTOs;
    }

    @GetMapping("/getVuelosAerolinea/{empresa}")
    public List<VuelosDTO> getVuelosAerolinea(@PathVariable("empresa") String nombreEmpresa) {
        List<Vuelos> vuelos = vuelosRepository.findByAerolinea(nombreEmpresa);
        List<VuelosDTO> vuelosDTOs = new ArrayList<>();
        for (Vuelos vuelo : vuelos) {
            vuelosDTOs.add(vuelosMapper.toDTO(vuelo));
        }
        return vuelosDTOs;
    }

    @GetMapping("/getAllVuelosAeropuerto/{empresa}")
    public List<VuelosDTO> getAllVuelosAeropuerto(@PathVariable("empresa") String nombreEmpresa) {
        List<Vuelos> vuelos = vuelosRepository.findVuelosAeropuerto(nombreEmpresa);

        List<VuelosDTO> vuelosDTOs = new ArrayList<>();
        for (Vuelos vuelo : vuelos) {
            vuelosDTOs.add(vuelosMapper.toDTO(vuelo));
        }

        return vuelosDTOs;
    }
    @GetMapping("/getVuelosAerolineaAceptados/{empresa}")
    public List<VuelosDTO> getVuelosAerolineaAceptados(@PathVariable("empresa") String nombreEmpresa) {
        List<Vuelos> vuelos = vuelosRepository.findVuelosAerolineaAceptados(nombreEmpresa);

        List<VuelosDTO> vuelosDTOs = new ArrayList<>();
        for (Vuelos vuelo : vuelos) {
            vuelosDTOs.add(vuelosMapper.toDTO(vuelo));
        }

        return vuelosDTOs;
    }
    @PostMapping("/vuelosDisponibles")
    public List<VuelosDTO> vuelosDisponibles(@RequestBody OrigenDestino origenDestino){
        List<Vuelos> vuelosOrigenDestino= vuelosService.vuelosDisponibles(origenDestino.getOrigen(), origenDestino.getDestino());
        List<VuelosDTO> vuelosDisponiblesDTO=new ArrayList<>();
        for (Vuelos vuelos : vuelosOrigenDestino) {
            vuelosDisponiblesDTO.add(vuelosMapper.toDTO(vuelos));
        }
        return vuelosDisponiblesDTO;
    }

    

}
