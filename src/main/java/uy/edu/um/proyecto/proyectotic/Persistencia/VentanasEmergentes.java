package uy.edu.um.proyecto.proyectotic.Persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxWeaver;


@Component

public class VentanasEmergentes {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    public void ventanaError(String mensaje){
        
        Stage popupStage = new Stage();
        FxWeaver fxWeaver=applicationContext.getBean(FxWeaver.class);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.UTILITY);
        popupStage.setTitle("Popup Window");
/*
        Parent root = fxWeaver.loadView(errorEmergenteController.class);
        fxWeaver.getBean(errorEmergenteController.class).setMessageError(mensaje);
    	Scene scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.showAndWait();*/
    }
        
    
}
