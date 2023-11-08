package com.example.listas_menus;

import com.example.listas_menus.model.Pelicula;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private MenuItem itemAlerta, itemPregunta, itemSeleccion, itemSimple, itemTexto, itemWarning, itemPersonalizado;
    @FXML
    private RadioMenuItem menuDeshabilitar, menuHabilitar;
    @FXML
    private MenuItem menuSalir, menuAgregar,menuBorrar;
    private ToggleGroup grupoHabilitar;
    @FXML
    private BorderPane parteCentral;
    @FXML
    private ListView<Pelicula> listView;
    private DialogoPersoController dialogoController;
    @FXML
    private ChoiceBox<Pelicula> choice;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private SpinnerValueFactory<Integer> listaSpinner;
    @FXML
    private ObservableList<String> listaCombo;
    private ObservableList<Pelicula> listaListView;
    @FXML
    private ObservableList<Pelicula> listaChoice;
    @FXML
    private Button botonFiltrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instacias();
        personalizarMenu();
        acciones();
    }


    private void personalizarMenu() {
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("salir.png"))));
        menuSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        menuSalir.setMnemonicParsing(true);//la letra del acelerador la pone subrayada
    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem) t1).getText().equalsIgnoreCase("habilitar")) {
                    parteCentral.setDisable(false);
                } else {
                    parteCentral.setDisable(true);
                }
            }
        });
        menuAgregar.setOnAction(this);
        menuBorrar.setOnAction(this);
        menuSalir.setOnAction(this);
        itemAlerta.setOnAction(this);
        itemWarning.setOnAction(this);
        itemPregunta.setOnAction(this);
        itemSeleccion.setOnAction(this);
        itemSimple.setOnAction(this);
        itemTexto.setOnAction(this);
        itemPersonalizado.setOnAction(this);
        botonFiltrar.setOnAction(this);
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
            }
        });
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pelicula>() {
            @Override
            public void changed(ObservableValue<? extends Pelicula> observableValue, Pelicula pelicula, Pelicula t1) {
                System.out.println(t1);
            }
        });
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                System.out.println(t1);
            }
        });
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pelicula>() {
            @Override
            public void changed(ObservableValue<? extends Pelicula> observableValue, Pelicula pelicula, Pelicula t1) {
                System.out.println(pelicula.getTitulo());
            }
        });


    }

    private void instacias() {
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(menuHabilitar, menuDeshabilitar);
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaCombo.addAll("Terror", "Comedia", "Intriga", "Infantil");
        combo.setItems(listaCombo);
        listaChoice.addAll(new Pelicula("pelicula1", "terror", 1997), new Pelicula("peli2", "genero2", 2010), new Pelicula("pelicula3", "genero3", 2005), new Pelicula("peli4", "gen4", 1990));
        choice.setItems(listaChoice);
        listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5);
        spinner.setValueFactory(listaSpinner);
        listaListView = FXCollections.observableArrayList();
        listaListView.addAll(new Pelicula("1","1",1),new Pelicula("2","2",2));
        listView.setItems(listaListView);

       /* ObservableList listaOpciones = FXCollections.observableArrayList();
        listaOpciones.addAll("opcion1","opcion2","opcion3");
        listaSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(listaOpciones);*/
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuSalir) {
            System.exit(0);
        } else if (actionEvent.getSource() == itemSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuadro de informacion");
            alertSimple.setHeaderText("Cabecera de dialogo de informacion");
            alertSimple.setContentText("Contenido");
            alertSimple.show();
        } else if (actionEvent.getSource() == itemWarning) {
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuadro de warning");
            alertSimple.setHeaderText("Cabecera de dialogo de warning");
            alertSimple.setContentText("Contenido");
            alertSimple.show();
        } else if (actionEvent.getSource() == itemPregunta) {
            Alert dialogoPregunta = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType boton1 = new ButtonType("Preguntar mas tarde");
            ButtonType boton2 = new ButtonType("Aplicar y esperar");
            //dialogoPregunta.getButtonTypes().addAll(boton1,boton2,ButtonType.APPLY);
            dialogoPregunta.getButtonTypes().setAll(boton1, boton2, ButtonType.APPLY);
            Optional<ButtonType> boton = dialogoPregunta.showAndWait();
            if (boton.get() == ButtonType.OK) {
                System.out.println("Pulsado ok");
            } else if (boton.get() == ButtonType.CANCEL) {
                System.out.println("Pulsado cancelar");
            } else if (boton.get() == boton1) {
                System.out.println("Pulsado boton1");
            } else if (boton.get() == boton2) {
                System.out.println("Pulsado boton2");
            } else if (boton.get() == ButtonType.APPLY) {
                System.out.println("Pulsado cancelar");
            }
        } else if (actionEvent.getSource() == itemSeleccion) {
            //constructor acompañado del elemento seleccionado y de su lista
            ObservableList<Pelicula> listaOpciones = FXCollections.observableArrayList();
            listaOpciones.addAll(new Pelicula("t1", "g1", 200), new Pelicula("t2", "g2", 223));
            //el get 0 sera el que por defcto esta seleccionado
            ChoiceDialog<Pelicula> dialogoChoice = new ChoiceDialog<>(listaOpciones.get(0), listaOpciones);
            Optional<Pelicula> respuesta = dialogoChoice.showAndWait();
            if (respuesta.isPresent()) {
                System.out.println(respuesta.get().getGenero());
            } else {
                Alert alertaWarng = new Alert(Alert.AlertType.WARNING);
                alertaWarng.setHeaderText("Introduce seleccion");
                alertaWarng.show();
            }
        } else if (actionEvent.getSource() == itemTexto) {
            TextInputDialog dialogTexto = new TextInputDialog("Introduce datos");
            Optional<String> respuesta = dialogTexto.showAndWait();
            if (respuesta.isPresent()) {
                if (!respuesta.get().isEmpty()) {
                    System.out.println(respuesta.get());
                } else {
                    System.out.println("datos vacios");
                }
            } else {
                System.out.println("No hay datos");
            }
        } else if (actionEvent.getSource() == itemPersonalizado) {
            Dialog<Pelicula> dialogoPerso = new Dialog();
            dialogoPerso.setTitle("Cuadro personalizado");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogo-view.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                //despues de cargarlo inicio la controladora
                //la cogemos desde el nodo loader
                dialogoPerso = loader.getController();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialogoPerso.getDialogPane().setContent(root);
            dialogoPerso.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CLOSE);
            dialogoPerso.setResultConverter(new Callback<ButtonType, Pelicula>() {

                @Override
                public Pelicula call(ButtonType buttonType) {
                    if (buttonType == ButtonType.APPLY) {
                        //llamar a getPeli y isPeli
                        //necesito un objt de tipo controladora(DialogoController)
                        if (dialogoController.isPeli()) {
                            return dialogoController.getPelicula();
                        }
                    }
                    return null;
                }
            });
            Optional<Pelicula> respuesta = dialogoPerso.showAndWait();
            if (respuesta != null) {
                System.out.println(respuesta.get().getTitulo());
            }
        } else if (actionEvent.getSource() == botonFiltrar) {
            if (combo.getSelectionModel().getSelectedIndex() != -1 && choice.getSelectionModel().getSelectedIndex() != -1 && choice.getSelectionModel().getSelectedIndex() !=-1)  {

                System.out.println(combo.getSelectionModel().getSelectedItem());
                System.out.println(choice.getSelectionModel().getSelectedItem().getGenero());
                System.out.println(listView.getSelectionModel().getSelectedItem().getTitulo());
                System.out.println(spinner.getValue());
            } else {
                System.out.println("No hay nada saleccionado");
            }

        }else if (actionEvent.getSource() == menuAgregar){
            listaListView.add(new Pelicula("nueva","nueva",3));
            listView.refresh();
        } else if (actionEvent.getSource() == menuBorrar) {
            if (listView.getSelectionModel().getSelectedIndex()>-1){
            listaListView.remove(listView.getSelectionModel().getSelectedIndex());
            listView.refresh();
            listView.getSelectionModel().select(-1);
            }else {
                Alert aviso = new Alert(Alert.AlertType.WARNING);
                aviso.setHeaderText("No hay elemento selecionado");
                aviso.show();
            }
        }

    }
}