package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;

@Service
public class AerolineasService {
    @Autowired
    private AerolineaRepository aerolineaRepositorio;
    @Autowired
    private UsuariosService usuariosService;
    
    public void crearAereolinea(String nombre,String codigo,String contacto,String ubicacionSede,String email,String contra) throws Exception{
        if(aerolineaRepositorio.findByCodigo(codigo)==null){
            Aerolineas aerolinea=new Aerolineas();
            aerolinea.setCodigo(codigo);
            aerolinea.setNombre(nombre);
            aerolinea.setContacto(contacto);
            aerolinea.setSedePrincipal(ubicacionSede);
            aerolineaRepositorio.save(aerolinea);
            String nombreN="admin"+nombre;
            usuariosService.crearUsuario(email,nombreN,null,2,codigo,"Administrador",contra,null);
        } else {
            throw new Exception();
        }
    }

}
