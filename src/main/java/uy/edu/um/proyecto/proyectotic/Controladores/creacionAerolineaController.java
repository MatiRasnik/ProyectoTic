package uy.edu.um.proyecto.proyectotic.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Servicios.AerolineasService;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;
@Controller
@FxmlView("CreacionAerolineaPorAeropuerto.fxml")
public class creacionAerolineaController {

    @Autowired
    private VentanasEmergentes vEmergentes;

    @Autowired
    private AerolineasService aerolineasService;

    @Autowired
    private Configuraciones configuraciones;

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @FXML
    private Button botonAtrasCrearAerolinea;

    @FXML
    private TextField codigo_aerolinea_reg_aeropuerto;

    @FXML
    private TextField contacto_aerolinea_reg_aeropuerto;

    @FXML
    private TextField contra_aerolinea_reg_aeropuerto1;

    @FXML
    private TextField email_aerolinea_reg_aeropuerto1;

    @FXML
    private Button enviar_aerolinea_aeropuerto;

    @FXML
    private TextField nombre_aerolinea_reg_aeropuerto;

    @FXML
    private TextField sede_principal_aerolinea_reg_aeropuerto;

    @FXML
    void crearAereolinea(ActionEvent event) {
        try{
            aerolineasService.crearAereolinea(nombre_aerolinea_reg_aeropuerto.getText(), codigo_aerolinea_reg_aeropuerto.getText(), contacto_aerolinea_reg_aeropuerto.getText(), sede_principal_aerolinea_reg_aeropuerto.getText(), email_aerolinea_reg_aeropuerto1.getText(),contra_aerolinea_reg_aeropuerto1.getText());
        } catch (Exception e) {
            vEmergentes.ventanaError("Error al crear Aerolinea");
        }
    }

    @FXML
    void atras(ActionEvent event) {
        configuraciones.cambiarPantalla(botonAtrasCrearAerolinea.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

}