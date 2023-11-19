package uy.edu.um.proyecto.proyectotic.Servicios.RestServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.um.UsuariosDTO;
import uy.edu.um.AvionesDTO;
import uy.edu.um.ClienteTransporte;
import uy.edu.um.UsuarioTransporte;
import uy.edu.um.proyecto.proyectotic.Mappers.ClientesMapper;
import uy.edu.um.proyecto.proyectotic.Mappers.UsuariosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Clientes.Clientes;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.UsuariosRepository;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@RestController
public class UsuariosRestService {
    @Autowired
    private UsuariosMapper usuariosMapper;
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private ClientesMapper clientesMapper;

    @PostMapping("/addUsuarios")
    public void crearUsuario(@RequestBody UsuarioTransporte usuarioTransporte) throws Exception {
        Usuarios usuario = usuariosMapper.toUsuarios(usuarioTransporte.getUsuariosDTO());
        usuariosService.crearUsuario(usuario, usuarioTransporte.getLicenciaPiloto());
    }

    @GetMapping("/getUsuarios/{id}")
    public UsuariosDTO obtenerUsuario(@PathVariable("id") String email) throws Exception {
        Usuarios usr = usuariosService.getUsuarioId(email);
        UsuariosDTO usrDTO = usuariosMapper.toDTO(usr);
        return usrDTO;
    }

    @PostMapping("/verificarLogin")
    public Boolean verificarLogin(@RequestBody UsuariosDTO usr) throws Exception {
        return usuariosService.verificarLogin(usr.getEmail(), usr.getContrasena());

    }

    @PostMapping("/eliminarUsuario")
    public void eliminarUsuario(@RequestBody String id) throws Exception {
        usuariosService.eliminarUsuario(id);
    }

    @GetMapping("/getEmpleados/{empresa}")
    public List<UsuariosDTO> getEmpleados(@PathVariable("empresa") String nombreEmpresa) {
        List<Usuarios> empleados = usuariosRepository.findByEmpresa(nombreEmpresa);
        List<UsuariosDTO> empleadosDTO = new ArrayList<>();
        for (Usuarios empleado : empleados) {
            empleadosDTO.add(usuariosMapper.toDTO(empleado));
        }
        return empleadosDTO;
    }    @PostMapping("/registrarCliente")
    public void registrarCliente(@RequestBody ClienteTransporte clienteTransporte) throws Exception{
        Clientes cliente=clientesMapper.toClientes(clienteTransporte.getCliente());
        Usuarios usuario = usuariosMapper.toUsuarios(clienteTransporte.getUsuario());
        usuariosService.registroUsuarioCliente(usuario, cliente);
    }


}
