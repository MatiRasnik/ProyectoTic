package uy.edu.um.proyecto.proyectotic.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.UserSession;
import uy.edu.um.proyecto.proyectotic.Persistencia.VentanasEmergentes;
import uy.edu.um.proyecto.proyectotic.Servicios.UsuariosService;
import uy.edu.um.proyecto.proyectotic.Servicios.VuelosService;
@Controller
@FxmlView("creacionVuelo.fxml")
public class creacionVueloController {
    @Autowired
    VuelosService vuelosService;
    @Autowired
    Configuraciones conf;
    @Autowired
    ConfigurableApplicationContext applicationContext;
    @Autowired
    VentanasEmergentes vEmergentes;

    @FXML
    private TextField IATALlegadaCreacionVuelo;

    @FXML
    private TextField IATASalidaCreacionVuelo;

    @FXML
    private Button atrasCreacionVuelo;

    @FXML
    private Button botonCrearVuelo;

    @FXML
    private DatePicker fechaLlegadaCreacionVuelo;

    @FXML
    private DatePicker fechaSalidaCreacionVuelo;

    @FXML
    private TextField horaLlegadaCrecionVuelo;

    @FXML
    private TextField horaSalidaCreacionVuelo;

    @FXML
    private TextField matriculaAvionCreacionVuelo;

    @FXML
    private TextField numeroCreacionVuelo;

    @FXML
    void atras(ActionEvent event) {
        conf.cambiarPantalla(atrasCreacionVuelo.getScene(), vistaMenuAeropuertoController.class,applicationContext);
    }
    @FXML
    void crearVuelo(ActionEvent event){
        UserSession loggedInUser = UserSession.getInstace();
        try{
            vuelosService.crearVuelo(loggedInUser.getEmpresa(), matriculaAvionCreacionVuelo.getText(), IATASalidaCreacionVuelo.getText(), IATALlegadaCreacionVuelo.getText(),fechaSalidaCreacionVuelo.getValue(), horaSalidaCreacionVuelo.getText(), fechaLlegadaCreacionVuelo.getValue(), horaLlegadaCrecionVuelo.getText());
        } catch (Exception e){
            vEmergentes.ventanaError("Error al crear vuelo");
        }
        
    

    }
    
    
}
