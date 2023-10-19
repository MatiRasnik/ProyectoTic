package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;


@Service
public class AeropuertosService {


    @Autowired
    private AeropuertoRepository aeropuertoRepository;
    @Autowired
    private UsuariosService usuariosService;
    

    public void crearAeropuerto(Aeropuertos aeropuerto,String mail, String contrasena) throws Exception {
        /*try{
            cantidadMangasI=Integer.parseInt(cantidadMangas);
            cantidadPuertasI=Integer.parseInt(cantidadPuertas);
            cantidadPuestosI=Integer.parseInt(cantidadPuestos);

        } catch (Exception e){
            throw new Exception();
        }
        */
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
}
