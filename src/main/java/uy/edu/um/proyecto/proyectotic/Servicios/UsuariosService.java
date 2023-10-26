package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    

    public boolean verificarLogin(String email,String contrasena){
        boolean encontrado=false;
        Usuarios usuario=usuariosRepository.findByEmail(email);
        if(usuario!=null){
            if (usuario.getContrasena().equals(contrasena)){
                encontrado=true;
            }
            
        }
        return encontrado;
        
    }
    public Usuarios getUsuarioId(String email){
        Usuarios usuario=usuariosRepository.findByEmail(email);
        return usuario;
    }

    public void crearUsuario(Usuarios usuario, String licenciaPiloto) throws Exception{
        if (getUsuarioId(usuario.getEmail())!=null){
            throw new Exception();
        } else {
            usuariosRepository.save(usuario);
            if(usuario.getRol().equals("Piloto")){
                Pilotos piloto=new Pilotos();
                piloto.setEmail(usuario.getEmail());
                piloto.setLicenciaPiloto(licenciaPiloto);
                pilotosRepository.save(piloto);
  
            }
            
        }
    }
}
