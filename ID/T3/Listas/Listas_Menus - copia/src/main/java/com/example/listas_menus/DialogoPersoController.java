package com.example.listas_menus;

import com.example.listas_menus.model.Pelicula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPersoController implements Initializable {
@FXML
private TextField textNombre,textPass;
@FXML
private CheckBox checkRecordar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public boolean isPeli(){
        if (textNombre.getText().isEmpty() || textPass.getText().isEmpty()){
            return false;
        }
        return true;
    }
    public Pelicula getPelicula(){
        return new Pelicula(textNombre.getText(),"genero",Integer.parseInt(textPass.getText()));
    }

}
