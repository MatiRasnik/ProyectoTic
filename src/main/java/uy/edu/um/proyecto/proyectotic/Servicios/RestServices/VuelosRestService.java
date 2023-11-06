package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import uy.edu.um.VuelosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.VuelosMapper;
import uy.edu.um.proyecto.proyectotic.Servicios.VuelosService;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;

@RestController
public class VuelosRestService {
    @Autowired
    private VuelosMapper vuelosMapper;
    @Autowired
    private VuelosService vuelosService;


    @PostMapping("/crearVuelo")
    public void crearVuelo(@RequestBody VuelosDTO vuelosDTO) throws Exception{
        
        Vuelos vuelo = vuelosMapper.toVuelos(vuelosDTO);
        vuelosService.crearVuelo(vuelo);
    }

}
