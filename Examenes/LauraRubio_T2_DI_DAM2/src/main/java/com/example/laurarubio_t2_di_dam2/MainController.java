package com.example.laurarubio_t2_di_dam2;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private GridPane gridPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextArea textArea;
    @FXML
    private Button botonCarrito;
    @FXML
    private RadioButton radioPuntual, radioRecurrente;
    @FXML
    private TextField textCategoria, textNombre, textPrecio;

    @FXML
    private ToggleButton toggleCarrito, toggleOnOff;
    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        personalizarBotones();
        guardarDatos();
        utilizarGrupo();
    }

    private void utilizarGrupo() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioPuntual, radioRecurrente);
        radioPuntual.setUserData("Radio 1");
        radioRecurrente.setUserData("Radio 2");
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println("El radio seleccionado es el " + newValue.getUserData().toString());
            }
        });
    }
    private void guardarDatos() {
        if ((!textNombre.getText().isEmpty()) && (!textCategoria.getText().isEmpty()) && (!textPrecio.getText().isEmpty())) {
            String texto = textNombre.getText();
            String texto2 = textCategoria.getText();
            String texto3 = textPrecio.getText();
            textArea.appendText(texto + "\n");
            textArea.appendText(texto2 + "\n");
            textArea.appendText(texto3 + "\n");
        } else {
            System.out.println("Campos x rellenar");
        }
    }
    private void personalizarBotones() {
        String[] urlImage = new String[]{"C:\\Users\\laura\\Documents\\GitHub\\dam2\\Examenes\\LauraRubio_T2_DI_DAM2\\src\\main\\resources\\com\\example\\laurarubio_t2_di_dam2\\off.png",
                "C:\\Users\\laura\\Documents\\GitHub\\dam2\\Examenes\\LauraRubio_T2_DI_DAM2\\src\\main\\resources\\com\\example\\laurarubio_t2_di_dam2\\on.png"};
        toggleOnOff.setBorder(null);
        toggleOnOff.setBackground(null);
        toggleOnOff.setText("");
        ImageView imageToggleOnOff = new ImageView();
        toggleOnOff.setGraphic(imageToggleOnOff);
        imageToggleOnOff.imageProperty().bind(Bindings.when(toggleOnOff.selectedProperty()).then(new Image(urlImage[0])).otherwise(new Image(urlImage[1])));
        //-----------------------
        botonCarrito.setText("");
        botonCarrito.setBackground(null);
        botonCarrito.setBorder(null);
        botonCarrito.setGraphic(new ImageView(new Image("C:\\Users\\laura\\Documents\\GitHub\\dam2\\Examenes\\LauraRubio_T2_DI_DAM2\\src\\main\\resources\\com\\example\\laurarubio_t2_di_dam2\\carrito.png")));
        //---------------------
    }
    private void acciones() {
        botonCarrito.setOnAction(this);
        toggleOnOff.setOnAction(this);
        toggleCarrito.setOnAction(this);
        radioPuntual.setOnAction(this);
        radioRecurrente.setOnAction(this);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (toggleOnOff.isSelected()) {
            toggleOnOff.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                    if (t1) {
                        System.out.println("toggle d");
                        borderPane.setCenter(null);
                        borderPane.setRight(null);
                    } else {
                        //togle seleccionado -> permite realizar las demas opciones
                        System.out.println("toggle a");
                        borderPane.setCenter(gridPane);
                        botonCarrito.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                System.out.println("Boton pulsado");
                                guardarDatos();
                                textCategoria.setText("");
                                textNombre.setText("");
                                textPrecio.setText("");
                            }
                        });
                        if (toggleCarrito.isSelected()) {
                            toggleCarrito.selectedProperty().addListener(new ChangeListener<Boolean>() {
                                @Override
                                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t2) {
                                    if (t2) {
                                        System.out.println("desactivado");
                                        borderPane.setRight(textArea);
                                    } else {
                                        System.out.println("activado");
                                        borderPane.setRight(null);
                                    }
                                }
                            });
                        }

                    }
                }
            });
        }
    }
}