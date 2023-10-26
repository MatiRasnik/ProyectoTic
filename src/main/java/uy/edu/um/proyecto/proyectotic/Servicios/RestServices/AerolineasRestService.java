package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.AerolineasDTO;
import uy.edu.um.AerolineaTransporte;
import uy.edu.um.proyecto.proyectotic.Mappers.AerolineasMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Servicios.AerolineasService;

@RestController
@RequestMapping("/aerolineas")
public class AerolineasRestService {
    @Autowired
    private AerolineasMapper aerolineasMapper;
    @Autowired
    private AerolineasService aerolineasService;

    @PostMapping
    public void crearAerolineas(@RequestBody AerolineaTransporte aerolineaTransporte) throws Exception{
        Aerolineas aerolinea = aerolineasMapper.toAerolineas(aerolineaTransporte.getAerolineasDTO());
        aerolineasService.crearAereolinea(aerolinea, aerolineaTransporte.getEmail(), aerolineaTransporte.getContrasena());

    }

}
