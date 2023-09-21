package uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aerolineas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aerolineas {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String nombre;
    private String codigo;
    private String pais;
    private String telefono;

    // puede tener una lista de aviones

}
