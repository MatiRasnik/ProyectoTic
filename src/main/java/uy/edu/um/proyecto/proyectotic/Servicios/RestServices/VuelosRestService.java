package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import uy.edu.um.proyecto.proyectotic.Mappers.VuelosMapper;
import uy.edu.um.proyecto.proyectotic.Servicios.VuelosService;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;

@RestController
@RequestMapping("/vuelos")
public class VuelosRestService {

    private VuelosMapper vuelosMapper;
    private VuelosService vuelosService;

    @Autowired
    public VuelosRestService(VuelosMapper vuelosMapper, VuelosService vuelosService){
        this.vuelosMapper = vuelosMapper;
        this.vuelosService = vuelosService;
    }

    @PostMapping
    public void crearVuelo(@RequestBody VuelosDTO vuelosDTO) throws Exception{
        Vuelos vuelo = vuelosMapper.toVuelos(vuelosDTO);
    }

}
