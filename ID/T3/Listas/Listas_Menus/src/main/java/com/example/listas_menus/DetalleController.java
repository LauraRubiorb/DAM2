package com.example.listas_menus;

import com.example.listas_menus.model.PeliculaJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {
    @FXML
    private Label descripcion;
    @FXML
    private ImageView imagen;
    @FXML
    private Label media;
    @FXML
    private Label titulo;
    @FXML
    private Label votos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setPeliculaData(PeliculaJSON peliculaJSON){
        imagen.setImage(new Image("https://image.tmdb.org/t/p/w500/"+peliculaJSON.getBackdrop_path()));
        titulo.setText(peliculaJSON.getTitle());
        descripcion.setText(peliculaJSON.getOverview());
        votos.setText(String.valueOf(peliculaJSON.getVote_count()));
        media.setText(String.valueOf(peliculaJSON.getVote_average()));
    }


}
