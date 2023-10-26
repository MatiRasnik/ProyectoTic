package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import uy.edu.um.proyecto.proyectotic.Mappers.AeropuertosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;


import uy.edu.um.AeropuertoTransporte;

@RestController

public class AeropuertoRestService {
    @Autowired
    private AeropuertosMapper aeropuertoMapper;
    @Autowired
    private AeropuertosService aeropuertoService;

    @PostMapping("/crearAeropuertos")
    public void crearAeropuerto(@RequestBody AeropuertoTransporte aeropuertoTransporte ) throws Exception{
        Aeropuertos aeropuerto = aeropuertoMapper.toAeropuerto(aeropuertoTransporte.getAeropuertosDTO());
        aeropuertoService.crearAeropuerto(aeropuerto, aeropuertoTransporte.getEmail(), aeropuertoTransporte.getContrasena());

        
    }
    @PostMapping("/eliminarAeropuertos")
    public void eliminarAeropuerto(@RequestBody String id) throws Exception{
        aeropuertoService.eliminarAeropuerto(id);
    }



}
