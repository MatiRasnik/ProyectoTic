package uy.edu.um.proyecto.proyectotic.Mappers;

import org.springframework.stereotype.Component;

import uy.edu.um.ClientesDTO;
import uy.edu.um.proyecto.proyectotic.Persistencia.Clientes.Clientes;

@Component
public class ClientesMapper {
    
    public Clientes toClientes (ClientesDTO clientesDTO){

        Clientes cliente = new Clientes();
        cliente.setPasaporte(clientesDTO.getPasaporte());
        cliente.setEmail(clientesDTO.getEmail());
        cliente.setFechaNacimiento(clientesDTO.getFechaNacimiento());
        
        return cliente;
    }

    public ClientesDTO toDTO (Clientes cliente){

        ClientesDTO clientesDTO = new ClientesDTO();
       
        clientesDTO.setPasaporte(cliente.getPasaporte());
        clientesDTO.setEmail(cliente.getEmail());
        clientesDTO.setFechaNacimiento(cliente.getFechaNacimiento());
        
        return clientesDTO;

        
        
    }
}
