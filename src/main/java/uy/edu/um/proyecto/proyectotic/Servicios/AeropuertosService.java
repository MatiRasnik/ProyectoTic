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
    

    public void crearAeropuerto(String mail, String contrasena, String pais, String codigo, String nombre, String cantidadPuertas,String cantidadMangas,String cantidadPuestos) throws Exception {
        int cantidadMangasI=0;
        int cantidadPuertasI=0;
        int cantidadPuestosI=0;
        try{
            cantidadMangasI=Integer.parseInt(cantidadMangas);
            cantidadPuertasI=Integer.parseInt(cantidadPuertas);
            cantidadPuestosI=Integer.parseInt(cantidadPuestos);

        } catch (Exception e){
            throw new Exception();
        }
        if(aeropuertoRepository.findByCodigoIATA(codigo)==null){
            Aeropuertos aeropuerto = new Aeropuertos();
            aeropuerto.setCodigoIATA(codigo);
            aeropuerto.setNombre(nombre);
            aeropuerto.setPais(pais);
            aeropuerto.setCantidadMangas(cantidadMangasI);
            aeropuerto.setCantidadPuertas(cantidadPuertasI);
            aeropuerto.setCantidadPuestos(cantidadPuestosI);
            aeropuertoRepository.save(aeropuerto);
            String nombreU="admin"+nombre;
            try{
                usuariosService.crearUsuario(mail, nombreU, null, 1, nombre, "Administrador", contrasena,null);
            } catch (Exception e){
                throw new Exception();
            }
            
            
        } else {
            throw new Exception();
        }
    }
}
