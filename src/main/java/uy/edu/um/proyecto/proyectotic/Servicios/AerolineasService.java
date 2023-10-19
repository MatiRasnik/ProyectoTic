package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;

@Service
public class AerolineasService {
    @Autowired
    private AerolineaRepository aerolineaRepositorio;
    @Autowired
    private UsuariosService usuariosService;
    
    public void crearAereolinea(Aerolineas aerolinea, String email,String contra) throws Exception{
        if(aerolineaRepositorio.findByCodigo(aerolinea.getCodigo())==null){
            aerolineaRepositorio.save(aerolinea);
            String nombreN="admin"+aerolinea.getNombre();
            Usuarios usr=new Usuarios(email,nombreN,null,contra,2,"Administrador",aerolinea.getCodigo());
            usuariosService.crearUsuario(usr,null);
        } else {
            throw new Exception();
        }
    }

}
