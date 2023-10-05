package uy.edu.um.proyecto.proyectotic.Persistencia.Aviones;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aviones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aviones {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String modelo;
    private String matricula;
    private int cantidadPasajeros;
    private float capacidad;
    private float distanciaVuelo;
    private String empresa;
}
