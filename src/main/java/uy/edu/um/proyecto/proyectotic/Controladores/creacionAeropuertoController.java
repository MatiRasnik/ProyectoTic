package uy.edu.um.proyecto.proyectotic.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;

@Controller
@FxmlView("CreacionAeropuerto.fxml")
public class creacionAeropuertoController {

    @Autowired
    private AeropuertosService aeropuertosService;

    @Autowired
    private Configuraciones configuraciones;

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Autowired
    VentanasEmergentes vEmergentes;

    @FXML
    private Button botonAtrasCrearAeropuerto;

    @FXML
    private Button botonEviarCrearAeropuerto;

    @FXML
    private TextField cantidadMangasAeropuerto;

    @FXML
    private TextField cantidadPuertasAeropuerto;

    @FXML
    private TextField cantidadPuestosCheckInAeropuerto;

    @FXML
    private TextField codigoIataAeropuerto;

    @FXML
    private TextField contrasenaAeropuerto;

    @FXML
    private TextField emailCrearAeropuerto;

    @FXML
    private TextField nombreCearAeropuerto;

    @FXML
    private TextField paisCrearAeropuerto;

    @FXML
    void crearAeropuerto(ActionEvent event) {
        try{
            aeropuertosService.crearAeropuerto(emailCrearAeropuerto.getText(), contrasenaAeropuerto.getText(), paisCrearAeropuerto.getText(), codigoIataAeropuerto.getText(), nombreCearAeropuerto.getText(), cantidadPuertasAeropuerto.getText(), cantidadMangasAeropuerto.getText(), cantidadPuestosCheckInAeropuerto.getText());
        } catch (Exception e){
            vEmergentes.ventanaError("Error al crear Aereopuerto");
        }
        
    }

    @FXML
    void atras(ActionEvent event) {
        configuraciones.cambiarPantalla(botonAtrasCrearAeropuerto.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

}
