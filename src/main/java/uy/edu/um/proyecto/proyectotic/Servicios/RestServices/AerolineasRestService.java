package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.um.proyecto.proyectotic.Mappers.AerolineasMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Servicios.AerolineasService;

@RestController
@RequestMapping("/aerolineas")
public class AerolineasRestService {
    private AerolineasMapper aerolineasMapper;
    private AerolineasService aerolineasService;

    @Autowired
    public AerolineasRestService(AerolineasMapper aerolineasMapper, AerolineasService aerolineasService){
        this.aerolineasMapper = aerolineasMapper;
        this.aerolineasService = aerolineasService;
    }

    @PostMapping
    public void crearAerolineas(@RequestBody AerolineasDTO aerolineasDTO) throws Exception{
        Aerolineas aerolineaa = aerolineasMapper.toAerolineas(aerolineasDTO);
    }

}
