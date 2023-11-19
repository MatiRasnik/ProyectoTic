package uy.edu.um.proyecto.proyectotic.Persistencia.Clientes;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Clientes {

    @Id
    private String pasaporte;
    private LocalDate fechaNacimiento;
    private String email;
    
}
