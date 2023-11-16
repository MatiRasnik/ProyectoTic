package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.AeropuertoTransporte;
import uy.edu.um.AeropuertosDTO;
import uy.edu.um.AvionesDTO;
import uy.edu.um.UsuariosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.AvionesMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Servicios.AvionesService;

@RestController
public class AvionesRestService {
    @Autowired
    private AvionesMapper avionesMapper;
    @Autowired
    private AvionesService avionesService;
    @Autowired
    private AvionesRepository avionesRepository;

    @PostMapping("/crearAvion")
    public void crearAvion(@RequestBody AvionesDTO avionesDTO) throws Exception {
        Aviones avion = avionesMapper.toAviones(avionesDTO);

        avionesService.crearAvion(avion);
    }

    @GetMapping("/getAviones/{empresa}")
    public List<AvionesDTO> getAviones(@PathVariable("empresa") String nombreEmpresa) {
        List<Aviones> aviones = avionesRepository.findByEmpresa(nombreEmpresa);
        List<AvionesDTO> avionesDTOs = new ArrayList<>();
        for (Aviones avion : aviones) {
            avionesDTOs.add(avionesMapper.toDTO(avion));
        }
        return avionesDTOs;
    }

}
