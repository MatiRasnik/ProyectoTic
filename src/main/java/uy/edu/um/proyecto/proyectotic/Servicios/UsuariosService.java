package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Clientes.Clientes;
import uy.edu.um.proyecto.proyectotic.Persistencia.Clientes.ClientesRepository;
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
    @Autowired
    private ClientesRepository clientesRepository;
    

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
    public void eliminarUsuario(String email) throws Exception{
        Usuarios usr=usuariosRepository.findByEmail(email);
        if(usr==null){
            throw new Exception();
        } else {
            usuariosRepository.delete(usr);
        }
    }
    public Clientes getClientePasaporte(String pasaporte){
        Clientes cliente = clientesRepository.findByPasaporte(pasaporte);
        return cliente;
    }
    @Transactional
    public void registroUsuarioCliente(Usuarios usuario, Clientes cliente) throws Exception{
        if (getUsuarioId(usuario.getEmail())!=null || getClientePasaporte(cliente.getPasaporte()) != null){
            throw new Exception();
        } else {
            try {
                usuariosRepository.save(usuario);
                clientesRepository.save(cliente);
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }
    public Clientes buscarClienteEmail(String email) throws Exception{
        Clientes cliente=clientesRepository.findByEmail(email);
        if(cliente==null){
            throw new Exception();
        }
        return cliente;

    }
}
