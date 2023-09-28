package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.FlashMapManager;

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
    public Usuarios inicioSesion(String email,String contrasena){
        Usuarios usr=null;
        if(verificarExistencia(email)){
             Usuarios usuario=usuariosRepository.findByEmail(email);
             if(usuario.getContrasena().equals(contrasena)){
                usr=usuario;
             }
        }
        return usr;
    }

    public void crearUsuario(String email,String nombre, String apellido, int permiso, String empresa, String rol, String contrasena) throws Exception{
        if (verificarExistencia(email)){
            throw new Exception();
        } else {
            Usuarios usuario=new Usuarios();
            usuario.setApellido(apellido);
            usuario.setRol(rol);
            usuario.setNombre(nombre);
            usuario.setPermiso(permiso);
            usuario.setEmpresa(empresa);
            usuario.setEmail(email);
            usuario.setContrasena(contrasena);

            usuariosRepository.save(usuario);
            
        }
    }
}
