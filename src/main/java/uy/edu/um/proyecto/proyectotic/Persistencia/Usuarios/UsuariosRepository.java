package uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository extends JpaRepository<Usuarios,String>{
    @Query("SELECT u FROM Usuarios u WHERE u.email = ?1")
    Usuarios findByEmail(String email);

    
}
