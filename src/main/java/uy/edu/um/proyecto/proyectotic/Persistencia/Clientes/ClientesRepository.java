package uy.edu.um.proyecto.proyectotic.Persistencia.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;





public interface ClientesRepository extends JpaRepository<Clientes,String> {
    public Clientes findByPasaporte(String pasaporte);
    public Clientes findByEmail(String email);


    
}
