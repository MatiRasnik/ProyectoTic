package uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    private String email;

    private String nombre;

    private String apellido;
    
    private String contrasena;

    private int permiso;

    private String rol;

    private String empresa;


    
}
