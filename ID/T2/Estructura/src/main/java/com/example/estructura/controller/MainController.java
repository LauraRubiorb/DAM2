package com.example.estructura.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button botonAdd, botonObtain;
    @FXML
    private TextField textoNombre;
    @FXML
    private Label mensaje1;
    private ArrayList<String> listaUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        botonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textoNombre.getText().length()>0) {
                    listaUser.add(textoNombre.getText());
                    mensaje1.setText("Agregado correctamente");
                    textoNombre.clear();
                } else {
                    mensaje1.setText("Porfavor introduzca algun dato");
                }
            }
        });
        botonObtain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (listaUser.size()>0){
                    int aleatorio = (int)(Math.random()* listaUser.size());
                    mensaje1.setText("Usuario : "+listaUser.get(aleatorio));
                }else {
                    System.out.println("No hay usuarios");
                }
            }
        });
    }
    public void instancias(){
        listaUser = new ArrayList<>();
    }
}
