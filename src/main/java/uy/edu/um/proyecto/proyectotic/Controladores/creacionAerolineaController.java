package uy.edu.um.proyecto.proyectotic.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Servicios.AeropuertosService;
@Controller
@FxmlView("CreacionAerolineaPorAeropuerto.fxml")
public class creacionAerolineaController {

    @Autowired
    private AeropuertosService aeropuertosService;

    @FXML
    private TextField codigo_aerolinea_reg_aeropuerto;

    @FXML
    private TextField contacto_aerolinea_reg_aeropuerto;

    @FXML
    private Button enviar_aerolinea_aeropuerto;

    @FXML
    private TextField nombre_aerolinea_reg_aeropuerto;

    @FXML
    private TextField sede_principal_aerolinea_reg_aeropuerto;

    @FXML
    void crearAereolinea(ActionEvent event) {
        aeropuertosService.crearAereolinea(nombre_aerolinea_reg_aeropuerto.getText(), codigo_aerolinea_reg_aeropuerto.getText(), contacto_aerolinea_reg_aeropuerto.getText(), sede_principal_aerolinea_reg_aeropuerto.getText());
        
    }

}