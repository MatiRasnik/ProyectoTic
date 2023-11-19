package uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class PasajerosVuelosId implements Serializable {
    private String pasaporte;
    private String codigoVuelo;

    
}
