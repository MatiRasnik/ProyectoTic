package uy.edu.um.proyecto.proyectotic.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.UserSession;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Servicios.AvionesService;

@Controller
@FxmlView("CrearAvion.fxml")
public class creacionAvionController {
    @Autowired
    ConfigurableApplicationContext applicationContext;
    @Autowired
    private Configuraciones configuraciones;
    @Autowired
    AvionesService avionesService;
    @Autowired
    VentanasEmergentes vEmergentes;

    @FXML
    private TextField CapacidadCargaCrearAvionAerolinea1;

    @FXML
    private TextField CapacidadPersonasCrearAvionAerolinea;

    @FXML
    private TextField DistanciaCrearAvionAerolinea;

    @FXML
    private TextField MatriculaCrearAvionAerolinea;

    @FXML
    private TextField ModeloCrearAvionAerolinea;

    @FXML
    private Button botonAtrasCrearEmpleadoAerolinea;

    @FXML
    private Button botonCrearAvionAerolinea;

    @FXML
    void atras(ActionEvent event) {
        configuraciones.cambiarPantalla(botonCrearAvionAerolinea.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

    @FXML
    void crearAvion(ActionEvent event){
        UserSession usr=UserSession.getInstace();
        try{
            avionesService.crearAvion(MatriculaCrearAvionAerolinea.getText(), ModeloCrearAvionAerolinea.getText(), CapacidadPersonasCrearAvionAerolinea.getText(), CapacidadCargaCrearAvionAerolinea1.getText(), DistanciaCrearAvionAerolinea.getText(),usr.getEmpresa() );
        } catch (Exception e){
            vEmergentes.ventanaError("Error al crear avion.");
        }
    }

}

