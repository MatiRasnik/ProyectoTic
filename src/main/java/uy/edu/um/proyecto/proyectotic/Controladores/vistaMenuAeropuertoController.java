package uy.edu.um.proyecto.proyectotic.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Window;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;

@Controller
@FxmlView("vista_Aeropuerto.fxml")
public class vistaMenuAeropuertoController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private Configuraciones conf;

    @FXML
    private Menu AerolineaDesplegable;

    @FXML
    private MenuItem CrearAerolineaMenu;

    @FXML
    private MenuBar menuAeropuerto;

    @FXML
    void desVentanaAerolinea(ActionEvent event){
        conf.cambiarPantalla(menuAeropuerto.getScene(), creacionAerolineaController.class,applicationContext);
    }

    @FXML
    void desVentanaAeropuerto(ActionEvent event){
        conf.cambiarPantalla(menuAeropuerto.getScene(), creacionAeropuertoController.class,applicationContext);
    }

    @FXML
    void crearEmpleadoAeropuerto(ActionEvent event){
        conf.cambiarPantalla(menuAeropuerto.getScene(), creacionEmpleadoAeropuertoController.class, applicationContext);
    }
    @FXML
    void CrearAvionVista(ActionEvent event){
        conf.cambiarPantalla(menuAeropuerto.getScene(), creacionAvionController.class, applicationContext);
    }

}

