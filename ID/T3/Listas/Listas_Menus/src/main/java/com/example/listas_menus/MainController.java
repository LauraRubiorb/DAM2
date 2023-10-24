package com.example.listas_menus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private MenuItem itemAlerta, itemPregunta, itemSeleccion, itemSimple, itemTexto, itemWarning;
    @FXML
    private RadioMenuItem menuDeshabilitar, menuHabilitar;
    @FXML
    private MenuItem menuSalir;
    @FXML
    private GridPane gridCentral;
    private ToggleGroup grupoHabilitar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instacias();
        personalizarMenu();
        acciones();
    }

    private void personalizarMenu() {
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("salir.png"))));
        menuSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.CONTROL_DOWN));
        menuSalir.setMnemonicParsing(true);//la letra del acelerador la pone subrayada
    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem)t1).getText().equalsIgnoreCase("habilitar")){
                    gridCentral.setDisable(false);
                }else {
                    gridCentral.setDisable(true);
                }
            }
        });
        menuSalir.setOnAction(this);
        itemAlerta.setOnAction(this);
        itemWarning.setOnAction(this);
        itemPregunta.setOnAction(this);
        itemSeleccion.setOnAction(this);
        itemSimple.setOnAction(this);
        itemTexto.setOnAction(this);

    }

    private void instacias() {
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(menuHabilitar,menuDeshabilitar);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuSalir){
            System.exit(0);
        } else if (actionEvent.getSource() == itemSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuadro de informacion");
            alertSimple.setHeaderText("Cabecera de dialogo de informacion");
            alertSimple.setContentText("Contenido");
            alertSimple.show();
        }else if (actionEvent.getSource() == itemWarning) {
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuadro de warning");
            alertSimple.setHeaderText("Cabecera de dialogo de warning");
            alertSimple.setContentText("Contenido");
            alertSimple.show();
        }
    }
}