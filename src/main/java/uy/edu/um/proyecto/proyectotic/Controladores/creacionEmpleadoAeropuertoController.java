package uy.edu.um.proyecto.proyectotic.Controladores;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.UserSession;
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
    private  Label LicenciaPilotoLabel;
    @FXML
    private TextField LicenciaPiloto; 
    @FXML

    public void initialize(){
        UserSession loggedInUser = UserSession.getInstace();
        LicenciaPiloto.setVisible(false);
        LicenciaPilotoLabel.setVisible(false);
        if(loggedInUser!=null){
            if(loggedInUser.getPermiso()==1){
                RolesEmpleadoAeropuerto.getItems().removeAll(RolesEmpleadoAeropuerto.getItems());
                RolesEmpleadoAeropuerto.setValue("Seleccione");
                RolesEmpleadoAeropuerto.getItems().setAll("Administrador","Check-In","Valijero","Gerente Vuelos","Transportista");
            } else if(loggedInUser.getPermiso()==2){
                RolesEmpleadoAeropuerto.getItems().removeAll(RolesEmpleadoAeropuerto.getItems());
                RolesEmpleadoAeropuerto.setValue("Seleccione");
                RolesEmpleadoAeropuerto.getItems().setAll("Administrador","Piloto");
                RolesEmpleadoAeropuerto.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                   if (newValue=="Piloto"){
                    LicenciaPiloto.setVisible(true);
                    LicenciaPilotoLabel.setVisible(true);
                   } else{
                    LicenciaPiloto.setVisible(false);
                    LicenciaPilotoLabel.setVisible(false);
                    
                   }
                }); 
            } else if(loggedInUser.getPermiso()==0){
                RolesEmpleadoAeropuerto.getItems().removeAll(RolesEmpleadoAeropuerto.getItems());
                RolesEmpleadoAeropuerto.setValue("Seleccione");
                RolesEmpleadoAeropuerto.getItems().setAll("Administrador");
            }
        } else {
            vEmergentes.ventanaError("Error al Inicio de Sesion");
        }
    }

    @FXML

    void crearEmpleado(ActionEvent action){
        UserSession loggedInUser = UserSession.getInstace();
        
        try{
            usuariosService.crearUsuario(emailCrearEmpleadoAeropuerto.getText(), nombreCearEmpleadoAeropuerto.getText(), apellidoCrearEmpleadoAeropuerto.getText(), loggedInUser.getPermiso(), loggedInUser.getEmpresa(), RolesEmpleadoAeropuerto.getValue(), contraseñaCrearEmpleadoAeropuerto.getText(),LicenciaPiloto.getText());
        } catch(Exception e){
            vEmergentes.ventanaError("Error al crear Usuario");
        }
        
    }
    @FXML
    void atras(ActionEvent event) {
        conf.cambiarPantalla(botonAtrasCrearAeropuerto.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }


}
