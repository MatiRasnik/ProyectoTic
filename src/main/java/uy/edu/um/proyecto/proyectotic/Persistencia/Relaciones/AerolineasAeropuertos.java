package uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

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
@Table(name="aerolineasAeropuertos")
public class AerolineasAeropuertos {

    @EmbeddedId
    private AerolineasAeropuertosId id;
    
}
