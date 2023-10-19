package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.FlashMapManager;

import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.Pilotos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos.PilotosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PilotosRepository pilotosRepository;

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

    public void crearUsuario(Usuarios usuario, String licenciaPiloto) throws Exception{
        if (verificarExistencia(usuario.getEmail())){
            throw new Exception();
        } else {
            usuariosRepository.save(usuario);
            if(usuario.getRol()=="Piloto"){
                Pilotos piloto=new Pilotos();
                piloto.setEmail(usuario.getEmail());
                piloto.setLicenciaPiloto(licenciaPiloto);
                pilotosRepository.save(piloto);
  
            }
            
        }
    }
}
