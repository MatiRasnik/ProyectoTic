package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.um.proyecto.proyectotic.Mappers.AeropuertosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoRestService {

    private AeropuertosMapper aeropuertoMapper;
    private AeropuertosService aeropuertoService;

    @Autowired
    public AeropuertoRestService(AeropuertosMapper aeropuertoMapper, AeropuertosService aeropuertoService){
        this.aeropuertoMapper = aeropuertoMapper;
        this.aeropuertoService = aeropuertoService;
    }

    @PostMapping
    public void crearAeropuerto(@RequestBody AeropuertosDTO aeropuertoDTO) throws Exception{
        Aeropuertos aeropuerto = aeropuertoMapper.toAeropuerto(aeropuertoDTO);
    }



}
