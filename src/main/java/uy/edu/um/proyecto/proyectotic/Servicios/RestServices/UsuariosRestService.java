package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.um.proyecto.proyectotic.Mappers.UsuariosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosRestService {
    private UsuariosMapper usuariosMapper;
    private UsuariosService usuariosService;

    @Autowired
    public UsuariosRestService(UsuariosMapper usuariosMapper, UsuariosService usuariosService){
        this.usuariosMapper = usuariosMapper;
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public void crearUsuario(@RequestBody UsuariosDTO usuariosDTO) throws Exception{
        Usuarios usuario = usuariosMapper.toUsuarios(usuariosDTO);
    }

    @PostMapping
    public void inicioSesion(@RequestBody UsuariosDTO usuariosDTO) throws Exception{
        Usuarios usuario = usuariosMapper.toUsuarios(usuariosDTO);
    }

    @PostMapping
    public void verificarExistencia(@RequestBody UsuariosDTO usuariosDTO) throws Exception{
        Usuarios usuario = usuariosMapper.toUsuarios(usuariosDTO);
    }

}
