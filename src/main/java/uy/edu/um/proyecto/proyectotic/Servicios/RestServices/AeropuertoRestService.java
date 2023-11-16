package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.proyecto.proyectotic.Mappers.AeropuertosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;
import uy.edu.um.AeropuertoTransporte;
import uy.edu.um.AeropuertosDTO;
import uy.edu.um.AsociacionTransporte;
import uy.edu.um.DisponibilidadPuertasT;
import uy.edu.um.PuertasPistasTransporte;

@RestController

public class AeropuertoRestService {
    @Autowired
    private AeropuertosMapper aeropuertoMapper;
    @Autowired
    private AeropuertosService aeropuertoService;
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @PostMapping("/crearAeropuertos")
    public void crearAeropuerto(@RequestBody AeropuertoTransporte aeropuertoTransporte) throws Exception {
        Aeropuertos aeropuerto = aeropuertoMapper.toAeropuerto(aeropuertoTransporte.getAeropuertosDTO());
        aeropuertoService.crearAeropuerto(aeropuerto, aeropuertoTransporte.getEmail(),
                aeropuertoTransporte.getContrasena());

    }

    @PostMapping("/eliminarAeropuertos")
    public void eliminarAeropuerto(@RequestBody String id) throws Exception {
        aeropuertoService.eliminarAeropuerto(id);
    }

    @PostMapping("/asociarAerolineasAeropuertos")
    public void asociarAerolineaAeropuerto(@RequestBody AsociacionTransporte asociacionTransporte) throws Exception {

        aeropuertoService.asociarAerolineaAeropuerto(asociacionTransporte.getAerolinea(),
                asociacionTransporte.getAeropuerto());
    }

    @GetMapping("/getAeropuertos")
    public List<AeropuertosDTO> getAeropuertos() {
        List<Aeropuertos> aeropuertos = aeropuertoRepository.findAll();
        List<AeropuertosDTO> aeropuertosDTOs = new ArrayList<>();
        for (Aeropuertos combo : aeropuertos) {
            aeropuertosDTOs.add(aeropuertoMapper.toDTO(combo));
        }
        return aeropuertosDTOs;
    }

    @PostMapping("/puertasDisponibles")
    public List<String> mangasDisponibles(@RequestBody DisponibilidadPuertasT disponibilidadPuertas) throws Exception {

        String aeropuerto = disponibilidadPuertas.getAeropuerto();
        String hora = disponibilidadPuertas.getHora();
        LocalDate fecha = disponibilidadPuertas.getFecha();

        return aeropuertoService.disponibilidadPuertas(aeropuerto, fecha, hora);
    }

    @PostMapping("/pistasDisponibles")
    public List<String> pistasDisponbles(@RequestBody DisponibilidadPuertasT disponibilidadPuertas) throws Exception {

        String aeropuerto = disponibilidadPuertas.getAeropuerto();
        String hora = disponibilidadPuertas.getHora();
        LocalDate fecha = disponibilidadPuertas.getFecha();

        return aeropuertoService.disponibilidadPistas(aeropuerto, fecha, hora);
    }

    @PostMapping("/crearPuertas")
    public void crearPuertas(@RequestBody PuertasPistasTransporte puertasPistasTransporte) throws Exception {
        aeropuertoService.crearPuertas(puertasPistasTransporte.getAeropuerto(), puertasPistasTransporte.getLista());

    }

    @PostMapping("/crearPistas")
    public void crearPistas(@RequestBody PuertasPistasTransporte puertasPistasTransporte) throws Exception {
        aeropuertoService.crearPistas(puertasPistasTransporte.getAeropuerto(), puertasPistasTransporte.getLista());

    }
}
