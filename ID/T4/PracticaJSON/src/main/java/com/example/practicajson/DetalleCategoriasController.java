package com.example.practicajson;

import com.example.practicajson.model.CategoriasJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleCategoriasController implements Initializable {
    @FXML
    private Label idCategoria;
    @FXML
    private TextArea idDescripcion;
    @FXML
    private ImageView idImagen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idDescripcion.setWrapText(true);
    }

    public void setDetallesCategory(CategoriasJSON categoriasJSON) {
        idCategoria.setText(categoriasJSON.getStrCategory());
        idImagen.setImage(new Image(categoriasJSON.getStrCategoryThumb()));
        idDescripcion.setText(categoriasJSON.getStrCategoryDescription());
    }
}
