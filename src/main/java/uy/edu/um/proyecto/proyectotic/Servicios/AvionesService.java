package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepository;

@Service
public class AvionesService {

    @Autowired
    private AvionesRepository avionesRepositorio;

    public void crearAvion(Aviones avion) throws Exception{
        String matricula=avion.getMatricula();
        if(avionesRepositorio.findByMatricula(matricula)==null){
            avionesRepositorio.save(avion);           
        } else {
            throw new Exception();
        }
    
        


    }
}
