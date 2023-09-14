package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public boolean verificarExistencia(String email){
        Boolean encontrado=false;
        Usuarios usuario=usuariosRepository.findByEmail(email);
        if(usuario!=null){
            encontrado=true;
        }
        return encontrado;
        
    }
    public int inicioSesion(String email,String contrasena){
        int permiso=-1;
        if(verificarExistencia(email)){
             Usuarios usuario=usuariosRepository.findByEmail(email);
             if(usuario.getContrasena().equals(contrasena)){
                permiso=usuario.getPermiso();
             }
        }
        return permiso;
    }
}
