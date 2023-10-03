package com.example.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private BorderPane BorderGeneral;

    @FXML
    private Button botonCentro, botonDer, botonIzq;

    @FXML
    private HBox ParteDer, ParteIzq, ParteSuperior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalizarBotones();
        acciones();
    }

    private void acciones() {
        //llamo al evento this de la clase el metodo HANDLe
        botonCentro.setOnAction(this);
        botonDer.setOnAction(this);
        botonIzq.setOnAction(this);
        botonIzq.setOnMouseDragEntered(new ManejoRaton());
    }

    private void personalizarBotones() {
        cambiarBoton(botonCentro, "up.png");
        cambiarBoton(botonDer, "rigth.png");
        cambiarBoton(botonIzq, "left.png");
    }

    private void cambiarBoton(Button boton, String imagen) {
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(imagen))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //manejar los eventos ACTION
        System.out.println("Boton pulsado");
        class void ManejoRaton implements EventHandler<MouseEvent>() {

        }
    }
}