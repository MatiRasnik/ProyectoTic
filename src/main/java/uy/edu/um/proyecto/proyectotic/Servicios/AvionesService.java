package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.AvionesRepositorio;

@Service
public class AvionesService {

    @Autowired
    private AvionesRepositorio avionesRepositorio;

    public void crearAvion(String matricula,String modelo, String cantidadPersonas,String capacidadCarga,String distancia,String empresa) throws Exception{
        int cantidadPersonasI=Integer.parseInt(cantidadPersonas);
        float capacidadCargaF=Float.parseFloat(capacidadCarga);
        float distanciaF=Float.parseFloat(distancia);
        if(avionesRepositorio.findByMatricula(matricula)==null){
            Aviones avion=new Aviones(); 
            avion.setMatricula(matricula);
            avion.setModelo(modelo);
            avion.setCantidadPasajeros(cantidadPersonasI);
            avion.setCapacidad(capacidadCargaF);
            avion.setDistanciaVuelo(distanciaF);
            avion.setEmpresa(empresa);
            avionesRepositorio.save(avion);           
        } else {
            throw new Exception();
        }
    
        


    }
}
