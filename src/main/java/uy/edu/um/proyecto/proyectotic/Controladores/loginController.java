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
import uy.edu.um.proyecto.proyectotic.Persistencia.UserSession;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;

@Controller
@FxmlView("Login.fxml")
public class loginController {
    @Autowired
    VentanasEmergentes vEmergentes;
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
        Usuarios usuario = usuariosService.inicioSesion(usuario_login.getText(), contrasena_login.getText());
        if (usuario==null){
            vEmergentes.ventanaError("Usuario no Existe");
            System.out.println("Error al inicio de sesion");
        } else {
            int permiso=usuario.getPermiso();
            UserSession usr=UserSession.getInstace();
            usr.setEmpresa(usuario.getEmpresa());
            usr.setPermiso(permiso);
            usr.setUsername(usuario.getEmail());
            switch (permiso) {
                case 0:
                    System.out.println("Admin");
                    conf.cambiarPantalla(button_inciarsesion.getScene(), vistaMenuAeropuertoController.class,applicationContext);
                    break;
                case 1:
                    System.out.println("Aeropuerto");
                    conf.cambiarPantalla(button_inciarsesion.getScene(), vistaMenuAeropuertoController.class,applicationContext);
                    break;
                case 2:
                    conf.cambiarPantalla(button_inciarsesion.getScene(), vistaMenuAeropuertoController.class,applicationContext);
                    System.out.println("Aerolinea");
                    break;
                case 3:
                    System.out.println("Usuario");
                    break;
                default:
                    vEmergentes.ventanaError("Usuario no Existe");
                    System.out.println("Error al inicio de sesion");
                    break;
            }
        }

        
    }



}
