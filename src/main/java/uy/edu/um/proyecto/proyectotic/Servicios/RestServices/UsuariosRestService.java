package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.UsuariosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.UsuariosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosRestService {
    @Autowired
    private UsuariosMapper usuariosMapper;
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public void crearUsuario(@RequestBody UsuariosDTO usuariosDTO, String licenciaPiloto) throws Exception{
        Usuarios usuario = usuariosMapper.toUsuarios(usuariosDTO);
        usuariosService.crearUsuario(usuario, licenciaPiloto);
    }

    @GetMapping
    public void inicioSesion(@RequestBody String email,String contrasena) throws Exception{
        usuariosService.inicioSesion(email, contrasena);
    }

    @GetMapping
    public void verificarExistencia(@RequestBody String email) throws Exception{
        usuariosService.verificarExistencia(email);
    }

}
