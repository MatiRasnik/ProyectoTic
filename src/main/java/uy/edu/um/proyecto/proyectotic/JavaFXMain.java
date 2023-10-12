package uy.edu.um.proyecto.proyectotic;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class JavaFXMain extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
            .sources(ProyectoTicApplication.class).run(args);

    }

    @Override
    public void start(Stage primaryStage){
		/*FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
		Parent root = fxWeaver.loadView(loginController.class);
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.show();

		*/

	}
	@Override
	public void stop() {
    	this.applicationContext.close();
    	Platform.exit();
		
	}
    
}
