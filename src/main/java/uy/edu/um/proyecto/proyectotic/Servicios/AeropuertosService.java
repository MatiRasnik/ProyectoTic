package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosId;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;


@Service
public class AeropuertosService {


    @Autowired
    private AeropuertoRepository aeropuertoRepository;
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private AerolineasAeropuertosRepository aerolineasAeropuertosRepository;

    public void crearAeropuerto(Aeropuertos aeropuerto,String mail, String contrasena) throws Exception {
        if(aeropuertoRepository.findByCodigoIATA(aeropuerto.getCodigoIATA())==null){
            aeropuertoRepository.save(aeropuerto);
            String nombreU="admin"+aeropuerto.getNombre();
            try{
                Usuarios usr= new Usuarios(mail,nombreU,null,contrasena,1,"Administrador",aeropuerto.getCodigoIATA());
                usuariosService.crearUsuario(usr,null);

            } catch (Exception e){
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
    public void eliminarAeropuerto(String codigo) throws Exception{
        Aeropuertos aeropuerto=aeropuertoRepository.findByCodigoIATA(codigo);
        if(aeropuerto==null){
            throw new Exception();
        } else {
            aeropuertoRepository.delete(aeropuerto);
        }
    }

    public void asociarAerolineaAeropuerto(String aerolinea, String aeropuerto) throws Exception{
        AerolineasAeropuertos asociacion = new AerolineasAeropuertos();
        AerolineasAeropuertosId id=new AerolineasAeropuertosId();
        id.setAerolinea(aerolinea);
        id.setAeropuerto(aeropuerto);
        asociacion.setId(id);
        if(aerolineasAeropuertosRepository.findByIdAerolineaAndIdAeropuerto(aerolinea, aeropuerto)==null){
            aerolineasAeropuertosRepository.save(asociacion);
        } else {
            throw new Exception();
        }
    }
}
