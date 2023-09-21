package uy.edu.um.proyecto.proyectotic.Persistencia;

import java.io.File;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;
import javafx.scene.Scene;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;


@Configuration
public class Configuraciones {
    @Bean
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
        // Would also work with javafx-weaver-core only:
        // return new FxWeaver(applicationContext::getBean, applicationContext::close);
        return new SpringFxWeaver(applicationContext); 
    }
    
    public void cambiarPantalla(Scene scene,Class<?> clase,ConfigurableApplicationContext applicationContext){
        FxWeaver fxWeaver=applicationContext.getBean(FxWeaver.class);
        Parent load=fxWeaver.loadView(clase);
        scene.setRoot(load);

    }

    
}
