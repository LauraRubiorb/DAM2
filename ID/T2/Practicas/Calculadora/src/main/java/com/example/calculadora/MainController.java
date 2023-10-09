package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private BorderPane bordeGeneral;
    @FXML
    private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0, botonC;
    @FXML
    private Button botonCientifica;
    @FXML
    private Button botonCos, botonLog, botonSin, botonTan;
    @FXML
    private Button botonHistorial;
    @FXML
    private VBox parteIzq;
    @FXML
    private TextArea textHistorial;
    @FXML
    private Button botonDividir, botonMultiplicar, botonRestar, botonIgual, botonMas;
    @FXML
    private GridPane gridBotones;
    @FXML
    private TextField textoCalculadora;
    private int operando1;
    private int operando2;
    private int operacion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //lo primero que hacer: primera accion
        acciones();
        bordeGeneral.setLeft(null);
        bordeGeneral.setRight(null);
    }

    private void acciones() {
        //la accion se la damos al borde general: cogemos sus hijos y lo recorremos con un for donde nos encontramos NODES
        //le preguntamos si all lo que encuentra en cada vuelta es un boton
        for (Node item : gridBotones.getChildren()) {
            if (item instanceof Button) {
                ((Button) item).setOnAction(this);
            }
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //gestionar todos las pulsaciones
        if (actionEvent.getSource() == boton1 || actionEvent.getSource() == boton2 || actionEvent.getSource() == boton3 || actionEvent.getSource() == boton4 ||
                actionEvent.getSource() == boton5 || actionEvent.getSource() == boton6 || actionEvent.getSource() == boton7 || actionEvent.getSource() == boton8 ||
                actionEvent.getSource() == boton9 || actionEvent.getSource() == boton0) {
            System.out.println("Pulsado boton");//cojo el primer operando
            textoCalculadora.appendText(((Button) actionEvent.getSource()).getText());
            operando2 = Integer.parseInt(textoCalculadora.getText());
            System.out.println(operando2);
        } else if (actionEvent.getSource() == botonMas || actionEvent.getSource() == botonMultiplicar ||
                actionEvent.getSource() == botonRestar || actionEvent.getSource() == botonDividir || actionEvent.getSource() == botonC) {
            //cuando pulse la operacion cojo el segundo operando y reseteo el texto
            operando1 = Integer.parseInt(textoCalculadora.getText());
            System.out.println(operando2);
            textoCalculadora.setText("");
            //vemos q operador es para unirlo al switch
            if (actionEvent.getSource() == botonMas) {
                operacion = 1;
            } else if (actionEvent.getSource() == botonRestar) {
                operacion = 2;
            } else if (actionEvent.getSource() == botonMultiplicar) {
                operacion = 3;
            } else if (actionEvent.getSource() == botonDividir) {
                operacion = 4;
            } else if (actionEvent.getSource() == botonC) {
                textoCalculadora.setText("");
            }
//control de aparicion de la pantalla de cientifica e historial
        } else if (actionEvent.getSource() == botonCientifica) {
            if (bordeGeneral.getLeft() == null) {
                bordeGeneral.setLeft(parteIzq);
                if (actionEvent.getSource() == botonLog) {
                    operacion = 5;
                } else if (actionEvent.getSource() == botonSin) {
                    operacion = 6;
                } else if (actionEvent.getSource() == botonTan) {
                    operacion = 7;
                } else if (actionEvent.getSource() == botonCos) {
                    operacion = 8;
                }
            } else {
                bordeGeneral.setLeft(null);
            }
        } else if (actionEvent.getSource() == botonHistorial) {
            if (bordeGeneral.getRight() == null) {
                bordeGeneral.setRight(textHistorial);
            } else {
                bordeGeneral.setRight(null);
            }
            //cuando pulse = realizará la operacion
        } else if (actionEvent.getSource() == botonIgual) {
            int resultado = 0;
            switch (operacion) {
                case 1:
                    resultado = operando1 + operando2;
                    break;
                case 2:
                    resultado = operando1 - operando2;
                    break;
                case 3:
                    resultado = operando1 * operando2;
                    System.out.println(resultado);
                    break;
                case 4:
                    resultado = operando1 / operando2;
                    break;
            }
            textoCalculadora.setText(String.valueOf(resultado));
        }
    }
}
