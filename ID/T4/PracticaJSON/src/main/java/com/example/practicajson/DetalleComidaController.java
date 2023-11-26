package com.example.practicajson;

import com.example.practicajson.model.ComidasJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleComidaController implements Initializable {
    @FXML
    private Label idComida,labelId;
    @FXML
    private ImageView idImagen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setDetalleComida(ComidasJSON comidasJSON){
        idComida.setText(comidasJSON.getStrMeal());
        labelId.setText(String.valueOf(comidasJSON.getIdMeal()));
        idImagen.setImage(new Image(comidasJSON.getStrMealThumb()));
    }
}
