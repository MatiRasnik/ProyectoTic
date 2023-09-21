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

@Controller
@FxmlView("vista_Aeropuerto.fxml")
public class vistaMenuAeropuertoController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @FXML
    private Menu AerolineaDesplegable;

    @FXML
    private MenuItem CrearAerolineaMenu;

    @FXML
    private MenuBar menuAeropuerto;

    @FXML

    void desVentanaAerolinea(ActionEvent event){
        FxWeaver fxWeaver=applicationContext.getBean(FxWeaver.class);
        Parent load=fxWeaver.loadView(creacionAerolineaController.class);
        Scene scene=menuAeropuerto.getScene();
        scene.setRoot(load);
        
    }

}

