package com.example.botones;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonImagen,botonNormal, botonPulsar, botonURL;
    @FXML
    private Tab botonesCompuestos, botonesNormales;
    @FXML
    private Button botonComprobar;
    @FXML
    private CheckBox check1, check2,check3;
    @FXML
    private RadioButton radio1,radio2,radio3;

    @FXML
    private ToggleButton toggle1,toggle2, toggle3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
acciones();
personalizarBotones();
    }

    private void personalizarBotones() {
        botonImagen.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("image1.png")))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);
        //botonURL.setGraphic(new ImageView(new Image("https://cdn2.vectorstock.com/i/1000x1000/75/41/red-button-with-chrome-frame-round-glass-shiny-3d-vector-21107541.jpg")));
        //botonURL.setBorder(null);
        //botonURL.setBackground(null);
    }

    private void acciones(){
        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonPulsar.setOnAction(this);
        botonComprobar.setOnAction(this);
        toggle1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean old, Boolean newValue) {
                if (newValue){
                    System.out.println("Elemento seleccionado");
                }else {
                    System.out.println("Elemento deseleccionado");
                }
            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar){
            toggle1.setSelected(true);
        }
        if (actionEvent.getSource() == botonNormal){
            
        } else if (actionEvent.getSource() == botonImagen) {
            
        } else if (actionEvent.getSource() == botonURL) {
            
        } else if (actionEvent.getSource() == botonPulsar) {
            
        }
    }
}