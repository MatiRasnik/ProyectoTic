package uy.edu.um.proyecto.proyectotic.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@Controller
@FxmlView("Login.fxml")
public class loginController {
    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    Configuraciones conf;

    @FXML
    private Button button_inciarsesion;

    @FXML
    private PasswordField contrasena_login;

    @FXML
    private TextField usuario_login;

    @FXML
    void onOKButtonClick(ActionEvent event) {
        int permiso = usuariosService.inicioSesion(usuario_login.getText(), contrasena_login.getText());

        switch (permiso) {
            case 1:
                System.out.println("Aeropuerto");
                conf.cambiarPantalla(button_inciarsesion.getScene(), vistaMenuAeropuertoController.class,applicationContext);
                break;
            case 2:
                System.out.println("Aerolinea");
                break;
            case 3:
                System.out.println("Usuario");
                break;
            default:
                System.out.println("Error al inicio de sesion");
                break;
        }
        
    }



}
