package uy.edu.um.proyecto.proyectotic.Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import uy.edu.um.proyecto.proyectotic.Persistencia.Configuraciones;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.VuelosRepository;

import java.util.List;

@Controller
@FxmlView("confirmarVueloAeropuerto.fxml")
public class confirmarVueloAeropuertoController {


    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private Configuraciones conf;

    @Autowired
    private VuelosRepository vuelosRepository;

    @FXML
    private TableView<Vuelos> TablaConfirmarVuelo;

    @FXML
    private TableColumn<?, ?> columnaFechaSalida;

    @FXML
    private ChoiceBox<?> mangaPistaDesginada;

    @FXML
    private Button botonAtrasConfirmarVuelo;

    @FXML
    private Button botonConfirmarVuelo;

    @FXML
    private TableColumn<?, ?> columnaFechaLlegada;

    @FXML
    public TableColumn<?,?> columnaNroVuelo;

    @FXML
    private TableColumn<?, ?> columnaAerppuertoSalida;

    @FXML
    private Button botonNegarVuelo;

    @FXML
    private TableColumn<?, ?> columnaAeropuertoLlegada;


    @FXML
    public void initialize() {
        System.out.println("Cargando datos desde la base de datos");

        List<Vuelos> vuelosList =  vuelosRepository.findAll();
        ObservableList<Vuelos> vuelosObservableList = FXCollections.observableArrayList(vuelosList);
        TablaConfirmarVuelo.setItems(vuelosObservableList);

        columnaAeropuertoLlegada.setCellValueFactory(new PropertyValueFactory<>("aeropuertoLlegada"));
        columnaAerppuertoSalida.setCellValueFactory(new PropertyValueFactory<>("aereopuertoSalida"));
        columnaNroVuelo.setCellValueFactory(new PropertyValueFactory<>("number"));
        columnaFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        columnaFechaLlegada.setCellValueFactory(new PropertyValueFactory<>("fechaLlegada"));



    }

    @FXML
    public void atras(ActionEvent actionEvent) {
        conf.cambiarPantalla(botonAtrasConfirmarVuelo.getScene(), loginController.class,applicationContext);
    }

    @FXML
    public void confirmarVuelo(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == botonConfirmarVuelo) {

            if (!TablaConfirmarVuelo.getSelectionModel().isEmpty()) {
                Vuelos vuelo = TablaConfirmarVuelo.getSelectionModel().getSelectedItems().get(0);

                // VERIFICAR SI ES LLEGADA O SALIDA
                vuelo.setEstadoAceptacionSalida(true);
                vuelosRepository.save(vuelo);

            } else {
                // error
            }


        } else if (source == botonNegarVuelo) {

            if (!TablaConfirmarVuelo.getSelectionModel().isEmpty()) {
                Vuelos vuelo = TablaConfirmarVuelo.getSelectionModel().getSelectedItems().get(0);

                // VERIFICAR SI ES LLEGADA O SALIDA
                vuelo.setEstadoAceptacionSalida(false);
                vuelosRepository.save(vuelo);

            } else {
                // error
            }

        }
    }
}
