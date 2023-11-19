package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.VuelosDTO;
import uy.edu.um.proyecto.proyectotic.Mappers.VuelosMapper;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosId;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.PasajerosVuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.PasajerosVuelosId;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.PasajerosVuelosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.VuelosRepository;

@Service
public class AerolineasService {
    @Autowired
    private AerolineaRepository aerolineaRepositorio;
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private PasajerosVuelosRepository pasajerosVuelosRepository;
    @Autowired
    private VuelosRepository vuelosRepository;
    @Autowired
    private VuelosMapper vuelosMapper;
    
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

    public void eliminarAerolinea(String codigo) throws Exception{
        Aerolineas aerolinea=aerolineaRepositorio.findByCodigo(codigo);
        if(aerolinea==null){
            throw new Exception();
        } else {
            aerolineaRepositorio.delete(aerolinea);
        }
    }

    public void asignarVueloPasajero(String codigoVuelo, String pasaporte) throws Exception{
        PasajerosVuelos pasajerosVuelos = new PasajerosVuelos();
        PasajerosVuelosId id = new PasajerosVuelosId();
        id.setPasaporte(pasaporte);
        id.setCodigoVuelo(codigoVuelo);
        pasajerosVuelos.setId(id);
        
        if(pasajerosVuelosRepository.findByIdPasaporteAndIdCodigoVuelo(pasaporte, codigoVuelo)==null){
            pasajerosVuelosRepository.save(pasajerosVuelos);
        } else {
            throw new Exception();
        }
    }

    public List<VuelosDTO> vuelosPasajero(String pasaporte) throws Exception{
        List<VuelosDTO> vuelosDePasajero=new ArrayList<>();
        List<String> vuelos=pasajerosVuelosRepository.findByIdPasaporte(pasaporte);
        for (String vuelo : vuelos) {
            vuelosDePasajero.add(vuelosMapper.toDTO(vuelosRepository.findByCodigoVuelo(vuelo)));
        }
        return vuelosDePasajero;
    }

}
