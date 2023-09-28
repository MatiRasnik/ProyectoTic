package uy.edu.um.proyecto.proyectotic.Controladores;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@Controller
@FxmlView("CrearEmpleadoAeropuerto.fxml")
public class creacionEmpleadoAeropuertoController {

    @Autowired
    UsuariosService usuariosService;
    @Autowired
    Configuraciones conf;
    @Autowired
    ConfigurableApplicationContext applicationContext;
    @Autowired
    VentanasEmergentes vEmergentes;
    @FXML
    private ComboBox<String> RolesEmpleadoAeropuerto;

    @FXML
    private TextField apellidoCrearEmpleadoAeropuerto;

    @FXML
    private Button botonAtrasCrearAeropuerto;

    @FXML
    private Button botonCrearEmpleadoAeropuerto;

    @FXML
    private TextField contraseñaCrearEmpleadoAeropuerto;

    @FXML
    private TextField emailCrearEmpleadoAeropuerto;

    @FXML
    private TextField nombreCearEmpleadoAeropuerto;

    @FXML

    public void initialize(){
        RolesEmpleadoAeropuerto.getItems().removeAll(RolesEmpleadoAeropuerto.getItems());
        RolesEmpleadoAeropuerto.setValue("Administrador de Vuelos");
        RolesEmpleadoAeropuerto.getItems().setAll("Administrador empresas","Administrador equipaje");
    }

    @FXML

    public void crearEmpleado(ActionEvent action){
        try{
            usuariosService.crearUsuario(emailCrearEmpleadoAeropuerto.getText(), nombreCearEmpleadoAeropuerto.getText(), apellidoCrearEmpleadoAeropuerto.getText(), 3, "Aeropuerto1", RolesEmpleadoAeropuerto.getValue(), contraseñaCrearEmpleadoAeropuerto.getText());
        } catch(Exception e){
            vEmergentes.ventanaError("Error al crear Usuario");
        }
        
    }
    @FXML
    void atras(ActionEvent event) {
        conf.cambiarPantalla(botonAtrasCrearAeropuerto.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }

}
