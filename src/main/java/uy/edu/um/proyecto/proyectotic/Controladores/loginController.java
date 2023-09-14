package uy.edu.um.proyecto.proyectotic.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@Controller
@FxmlView("Login.fxml")
public class loginController {
    @Autowired
    UsuariosService usuariosService;

    @FXML
    private Button button_inciarsesion;

    @FXML
    private PasswordField contrasena_login;

    @FXML
    private TextField usuario_login;

    @FXML
    void onOKButtonClick(ActionEvent event) {
        int permiso = usuariosService.inicioSesion(usuario_login.getText(), contrasena_login.getText());
        if (permiso==-1){
            System.out.println("Error al inicio de sesion");
        } else {
            System.out.println("Ingresando al sistema...");
        }
        
    }



}
