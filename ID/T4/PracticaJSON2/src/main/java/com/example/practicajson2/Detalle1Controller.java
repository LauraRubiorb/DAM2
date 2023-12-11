package com.example.practicajson2;

import com.example.practicajson2.model.BebidasJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Detalle1Controller implements Initializable {
    @FXML
    private ImageView idImagen;
    @FXML
    private Label idNombre, idlabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setDetalles(BebidasJSON bebidasJSON){
        idlabel.setText(String.valueOf(bebidasJSON.getIdDrink()));
        idNombre.setText(String.valueOf(bebidasJSON.getStrDrink()));
        idImagen.setImage(new Image(bebidasJSON.getStrDrinkThumb()));
    }
}
