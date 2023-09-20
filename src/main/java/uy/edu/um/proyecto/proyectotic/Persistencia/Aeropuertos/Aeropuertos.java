package uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aeropuerto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aeropuertos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String ciudad;
    private String pais;
    private String codigo;
    private int cantidadPuertas;
    private int cantidadMangas;

    // puede tener una lista de las aerolineas que operan en el

}
