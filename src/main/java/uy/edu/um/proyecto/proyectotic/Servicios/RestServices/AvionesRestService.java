package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.um.proyecto.proyectotic.Mappers.AvionesMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Servicios.AvionesService;

@RestController
@RequestMapping("/aviones")
public class AvionesRestService {

    private AvionesMapper avionesMapper;
    private AvionesService avionesService;

    @Autowired
    public AvionesRestService(AvionesMapper avionesMapper, AvionesService avionesService){
        this.avionesMapper = avionesMapper;
        this.avionesService = avionesService;
    }

    @PostMapping
    public void crearAvion(@RequestBody AvionesDTO avionesDTO) throws Exception{
        Aviones avion = avionesMapper.toAviones(avionesDTO);
    }
}
