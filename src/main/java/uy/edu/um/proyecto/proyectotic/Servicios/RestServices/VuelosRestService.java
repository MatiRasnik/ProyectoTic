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
        List<Vuelos> vuelosSalida = vuelosRepository.findByAeropuertoSalida(nombreEmpresa);
        List<Vuelos> vuelosLlegada = vuelosRepository.findByAeropuertoLlegada(nombreEmpresa);

        System.out.println(nombreEmpresa);
        System.out.println(vuelosLlegada);
        System.out.println(vuelosSalida);

        List<VuelosDTO> vuelosDTOs = new ArrayList<>();
        for (Vuelos avion : vuelosSalida) {
            vuelosDTOs.add(vuelosMapper.toDTO(avion));
        }
        for (Vuelos avion : vuelosLlegada) {
            vuelosDTOs.add(vuelosMapper.toDTO(avion));
        }
        System.out.println(vuelosDTOs);
        return vuelosDTOs;
    }

}
