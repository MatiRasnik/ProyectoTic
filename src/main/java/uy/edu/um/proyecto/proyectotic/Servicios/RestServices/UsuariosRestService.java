package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.UsuariosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.UsuariosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@RestController
public class UsuariosRestService {
    @Autowired
    private UsuariosMapper usuariosMapper;
    @Autowired
    private UsuariosService usuariosService;
    
    @PostMapping("/addUsuarios")
    public void crearUsuario(@RequestBody UsuariosDTO usuariosDTO, String licenciaPiloto) throws Exception{
        Usuarios usuario = usuariosMapper.toUsuarios(usuariosDTO);
        usuariosService.crearUsuario(usuario, licenciaPiloto);
    }

    @GetMapping("/getUsuarios/{id}")
    public UsuariosDTO obtenerUsuario(@PathVariable("id") String email) throws Exception{
        Usuarios usr=usuariosService.getUsuarioId(email);
        UsuariosDTO usrDTO= usuariosMapper.toDTO(usr);
        return usrDTO;
    }

    @PostMapping("/verificarLogin")
    public Boolean verificarLogin(@RequestBody UsuariosDTO usr) throws Exception{
        return usuariosService.verificarLogin(usr.getEmail(), usr.getContrasena());
        
    }

}
