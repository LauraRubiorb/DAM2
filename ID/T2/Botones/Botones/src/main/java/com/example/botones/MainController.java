package com.example.botones;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonImagen, botonNormal, botonPulsar, botonURL;
    @FXML
    private Tab botonesCompuestos, botonesNormales;
    @FXML
    private Button botonComprobar;
    @FXML
    private CheckBox check1, check2, check3;
    @FXML
    private RadioButton radio1, radio2, radio3;

    @FXML
    private ToggleButton toggle1, toggle2, toggle3;
    private ToggleGroup grupoToggle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarGrupoToggle();
        acciones();
        personalizarBotones();
    }

    private void configurarGrupoToggle() {
        //sacar los toggles que hay y me devuelve una lista
        grupoToggle.getToggles().addAll(toggle2, toggle3);

    }

    private void instancias() {
        grupoToggle = new ToggleGroup();
    }

    private void personalizarBotones() {
        String[] urlToggle = new String[]{"https://upload.wikimedia.org/wikipedia/commons/b/bc/On_button.png",
                "https://upload.wikimedia.org/wikipedia/commons/2/23/Off_button.png"};
        toggle1.setBackground(null);
        toggle1.setBorder(null);
        toggle1.setText("");
        ImageView imageToggle = new ImageView();
        toggle1.setGraphic(imageToggle);
        imageToggle.imageProperty().bind(Bindings.when(toggle1.selectedProperty()).then(new Image(urlToggle[0])).otherwise(new Image(urlToggle[1])));
        botonImagen.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("image1.png")))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);
        //botonURL.setGraphic(new ImageView(new Image("https://cdn2.vectorstock.com/i/1000x1000/75/41/red-button-with-chrome-frame-round-glass-shiny-3d-vector-21107541.jpg")));
        //botonURL.setBorder(null);
        //botonURL.setBackground(null);
    }

    private void acciones() {
        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonPulsar.setOnAction(this);
        botonComprobar.setOnAction(this);
        toggle1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean old, Boolean newValue) {
                if (newValue) {
                    System.out.println("Elemento seleccionado");
                } else {
                    System.out.println("Elemento deseleccionado");
                }
            }
        });
        grupoToggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1 != null) {
                    System.out.println(((ToggleButton) t1).getText());
                }
            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar) {
            toggle1.setSelected(true);
            if (grupoToggle.getSelectedToggle() != null) {
                System.out.println(((ToggleButton) grupoToggle.getSelectedToggle()).getText());
            } else {
                System.out.println("No hay seleccion");
            }
        }
        if (actionEvent.getSource() == botonNormal) {

        } else if (actionEvent.getSource() == botonImagen) {

        } else if (actionEvent.getSource() == botonURL) {

        } else if (actionEvent.getSource() == botonPulsar) {

        }
    }
}