package uy.edu.um.proyecto.proyectotic.Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.AerolineaRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;

import java.awt.event.ActionEvent;
import java.util.List;

@Controller
@FxmlView("ListaAerolineasAeropuerto.fxml")
public class listaAeropuertoController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private Configuraciones conf;

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @FXML
    private Button button_cargarAerolineas;

    @FXML
    private TableView<Aerolineas> tablaDatosAerolinea;

    @FXML
    private TableColumn<Aerolineas, String> columnaNombreAerolinea;

    @FXML
    private TableColumn<Aerolineas, String> columnaContactoAerolinea;


    @FXML
    public void initialize() {
        System.out.println("Cargando datos desde la base de datos");

        List<Aerolineas> aerolineas = aerolineaRepository.findAll();
        ObservableList<Aerolineas> aerolineasObservableList = FXCollections.observableArrayList(aerolineas);
        tablaDatosAerolinea.setItems(aerolineasObservableList);

        columnaNombreAerolinea.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaContactoAerolinea.setCellValueFactory(new PropertyValueFactory("contacto"));
    }


    @FXML
    public void setButton_cargarAerolineas(javafx.event.ActionEvent actionEvent) {
    }
}
