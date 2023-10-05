package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aviones.Aviones;

@Entity
@Table(name="Vuelos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelos {
    @Id
    private String codigoVuelo;
    
    private String matricula;
    private String aereopuertoSalida;
    private String aeropuertoLlegada;
    private String estadoAceptacion;
    private String estadoVuelo;
    private LocalDate fechaSalida;
    private String horaSalida;
    private LocalDate fechaLlegada;
    private String horaLlegada;
    private String piloto;     
    
}
