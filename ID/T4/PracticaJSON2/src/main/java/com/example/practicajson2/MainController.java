package com.example.practicajson2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable , EventHandler<ActionEvent> {
    @FXML
    private Button botonDetalle1, botonDetalle2;

    @FXML
    private ChoiceBox<?> choiceIngre;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private ComboBox<?> comboAlcohol;
    ObservableList<?> listaCombo;

    @FXML
    private ListView<?> listaBebidas;

    @FXML
    private Spinner<?> spinnerCantidad;

    @FXML
    private TableView<?> tablaBebidas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        botonDetalle1.setOnAction(this);
        botonDetalle2.setOnAction(this);
    }

    private void instancias() {
        
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonDetalle1){

        } else if (actionEvent.getSource() == botonDetalle2) {

        }
    }
}