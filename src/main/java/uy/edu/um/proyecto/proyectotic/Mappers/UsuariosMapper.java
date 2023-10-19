package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;

import uy.edu.um.UsuariosDTO;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.Pilotos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;

@Component
public class UsuariosMapper {
    public Usuarios toUsuarios (UsuariosDTO usuariosDTO){

        Usuarios usuario = new Usuarios();
       
        usuario.setEmail(usuariosDTO.getEmail());
        usuario.setNombre(usuariosDTO.getNombre());
        usuario.setApellido(usuariosDTO.getApellido());
        usuario.setContrasena(usuariosDTO.getContrasena());
        usuario.setPermiso(usuariosDTO.getPermiso());
        usuario.setRol(usuariosDTO.getRol());
        usuario.setEmpresa(usuariosDTO.getEmpresa());

        
        return usuario;
    }

    public UsuariosDTO toDTO (Usuarios usuario){

        UsuariosDTO usuariosDTO = new UsuariosDTO();
       
        usuariosDTO.setEmail(usuario.getEmail());
        usuariosDTO.setNombre(usuario.getNombre());
        usuariosDTO.setApellido(usuario.getApellido());
        usuariosDTO.setContrasena(usuario.getContrasena());
        usuariosDTO.setPermiso(usuario.getPermiso());
        usuariosDTO.setRol(usuario.getRol());
        usuariosDTO.setEmpresa(usuario.getEmpresa());

        
        return usuariosDTO;
    }
}
