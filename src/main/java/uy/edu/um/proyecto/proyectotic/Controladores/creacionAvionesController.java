package uy.edu.um.proyecto.proyectotic.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.UserSession;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Servicios.AvionesService;

@Controller
@FxmlView("CrearAvion.fxml")
public class creacionAvionesController {

    @Autowired
    private AvionesService avionesService;

    @Autowired
    private Configuraciones configuraciones;

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Autowired
    VentanasEmergentes ventanasEmergentes;

    @FXML
    private TextField DistanciaCrearAvionAerolinea;

    @FXML
    private Button botonAtrasCrearEmpleadoAerolinea;

    @FXML
    private TextField ModeloCrearAvionAerolinea;

    @FXML
    private TextField CapacidadCargaCrearAvionAerolinea1;

    @FXML
    private TextField CapacidadPersonasCrearAvionAerolinea;

    @FXML
    private Button botonCrearAvionAerolinea;

    @FXML
    private TextField MatriculaCrearAvionAerolinea;

    @FXML
    void crearAvion(ActionEvent event)  {
        UserSession loggedUsuer = UserSession.getInstace();
        try {
            avionesService.crearAvion(MatriculaCrearAvionAerolinea.getText(), ModeloCrearAvionAerolinea.getText(), CapacidadPersonasCrearAvionAerolinea.getText(), CapacidadCargaCrearAvionAerolinea1.getText(), DistanciaCrearAvionAerolinea.getText(), loggedUsuer.getEmpresa());
        }catch (Exception e){
            ventanasEmergentes.ventanaError("Error al crear avion.");
        }
    }

    @FXML
    void atras(ActionEvent event) {
        configuraciones.cambiarPantalla(botonAtrasCrearEmpleadoAerolinea.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

}
