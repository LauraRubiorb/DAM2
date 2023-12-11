package com.example.laura_rubio_dam2_27_11;

import com.example.laura_rubio_dam2_27_11.model.EquiposJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetallesController implements Initializable {

    @FXML
    private TextArea idDescripcion;

    @FXML
    private ImageView idImagen;

    @FXML
    private Label idNombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setDetalles(EquiposJSON equiposJSON){
        idDescripcion.setText(equiposJSON.getStrStadiumDescription());
        idImagen.setImage(new Image(equiposJSON.getStrTeamBadge()));
        idNombre.setText(equiposJSON.getStrLeague());
    }
}
