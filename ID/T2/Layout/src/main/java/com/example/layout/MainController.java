package com.example.layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    @FXML
    private GridPane parteInferior;
    private DropShadow sombra;

    //MANEJO EVENTOS:
    //forma directa: elemento.SETON y tipo de accion ACTION(param EventHandler-> new EventHandler<ActionEvent>->@metodo handler)
    //Clase : clase Controller implementa interfaces elemento.SETONACTION(this

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        BorderGeneral.setLeft(null);
        BorderGeneral.setRight(null);
        BorderGeneral.setTop(null);
        personalizarBotones();
        acciones();
    }

    private void instancias() {
        sombra = new DropShadow();
    }

    private void acciones() {
        //llamo al evento this de la clase el metodo HANDLe
        botonCentro.setOnAction(this);
        botonDer.setOnAction(this);
        botonIzq.setOnAction(this);
        for (Node item:parteInferior.getChildren()) {
            item.setOnMouseEntered(new ManejoRaton());
            item.setOnMouseExited(new ManejoRaton());
        }
    }
    private void personalizarBotones() {
        cambiarBoton(botonCentro, "up.png");
        cambiarBoton(botonDer, "rigth.png");
        cambiarBoton(botonIzq, "left.png");
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                System.out.println("Raton entrado");
                ((Button) (mouseEvent.getSource())).setEffect(sombra);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) (mouseEvent.getSource())).setEffect(null);

            }
        }
    }

    private void cambiarBoton(Button boton, String imagen) {
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(imagen))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //manejar los eventos ACTION
        //ver la fuente del evento getSource
        if (actionEvent.getSource() == botonCentro) {
            System.out.println("Pulsado boton centro");
            if (BorderGeneral.getTop() == null) {
                BorderGeneral.setTop(ParteSuperior);
            } else {
                BorderGeneral.setTop(null);
            }
        } else if (actionEvent.getSource() == botonIzq) {
            System.out.println("Pulsado boton izq");
            if (BorderGeneral.getLeft() == null) {
                BorderGeneral.setLeft(ParteIzq);
            } else {
                BorderGeneral.setLeft(null);
            }
        } else if (actionEvent.getSource() == botonDer) {
            System.out.println("Pulsado boton der");
            if (BorderGeneral.getRight() == null) {
                BorderGeneral.setRight(ParteDer);
            } else {
                BorderGeneral.setRight(null);
            }
        }
    }
}
