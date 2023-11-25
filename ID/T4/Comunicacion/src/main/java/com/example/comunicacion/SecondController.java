package com.example.comunicacion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {
    @FXML
    Label nombre;
    @FXML
    private Button botonVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //comunicación unidiriccional:
        //1. metodo con lo que quiero obtener
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                // 2.crear escena y asociarla al root
                try {
                    Parent root = loader.load();
                    //comunicar paso2. obtener la controladora del destino y ejecuto el metodo.
                    MainController mainController = loader.getController();
                    mainController.setRespuesta();
                    Scene scene = new Scene(root, botonVolver.getScene().getWidth(), botonVolver.getScene().getHeight());
                    // 3. poner la escena en la ventana           //para sacar el stage necesito un elemento grafico:
                    Stage ventana = (Stage) botonVolver.getScene().getWindow();
                    ventana.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void comunicarNombre(String nom) {
        nombre.setText(nom);
    }
}
