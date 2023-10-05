package uy.edu.um.proyecto.proyectotic.Persistencia.Pilotos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="piloto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pilotos {

    @Id
    String licenciaPiloto;
    String email;
    
}
