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

@Controller
@FxmlView("CreacionAeropuerto.fxml")
public class creacionAeropuertoController {

    @Autowired
    private AeropuertosService aeropuertosService;

    @Autowired
    private Configuraciones configuraciones;

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @FXML
    private TextField emailCrearAeropuerto;

    @FXML
    private TextField contrasenaAeropuerto;

    @FXML
    private TextField paisCrearAeropuerto;

    @FXML
    private Button botonEviarCrearAeropuerto;

    @FXML
    private TextField codigoIataAeropuerto;

    @FXML
    private Button botonAtrasCrearAeropuerto;

    @FXML
    private TextField nombreCearAeropuerto;

    @FXML
    void crearAeropuerto(ActionEvent event) {
        aeropuertosService.crearAeropuerto(emailCrearAeropuerto.getText(), contrasenaAeropuerto.getText(), paisCrearAeropuerto.getText(), codigoIataAeropuerto.getText(), nombreCearAeropuerto.getText());
    }

    @FXML
    void atras(ActionEvent event) {
        configuraciones.cambiarPantalla(botonAtrasCrearAeropuerto.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

}
