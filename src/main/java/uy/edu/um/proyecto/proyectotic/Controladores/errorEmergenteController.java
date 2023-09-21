package uy.edu.um.proyecto.proyectotic.Controladores;

import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
@Controller
@FxmlView("error.fxml")
public class errorEmergenteController {
    @FXML
    private TextField messageError;
    
    public void setMessageError(String error) {
        messageError.setText(error);
    }

}
    

