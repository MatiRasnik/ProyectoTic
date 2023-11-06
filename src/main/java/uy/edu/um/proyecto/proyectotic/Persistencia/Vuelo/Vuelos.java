package uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long number;

    private String aerolinea;
    private String codigoVuelo;
    private String matricula;
    private String aeropuertoSalida;
    private String aeropuertoLlegada;
    private Boolean estadoAceptacionSalida;
    private Boolean estadoAceptacionLlegada;
    private String estadoVuelo;
    private LocalDate fechaSalida;
    private String horaSalida;
    private LocalDate fechaLlegada;
    private String horaLlegada;
    private String licenciaPiloto;     
    
}
