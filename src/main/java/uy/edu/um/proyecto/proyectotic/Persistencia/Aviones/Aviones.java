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
    private String matricula;

    private String modelo;
    private int cantidadPasajeros;
    private float capacidadCarga;
    private float distanciaDeDespegue;
    private float distanciaVuelo;
    private String empresa;
}
