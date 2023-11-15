package com.example.pizzeria;

import com.almasb.fxgl.core.collection.Array;
import com.example.pizzeria.model.Pedidos;
import com.example.pizzeria.model.Pizza;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    private Pizza pizza;
    private Pedidos pedidos;
    @FXML
    private Button botonRealizar, botonServir;
    @FXML
    private HBox boxButton, boxRadios;
    @FXML
    private VBox boxTexts;
    @FXML
    private MenuItem itemCaja, itemRealizar, itemServir;
    @FXML
    private ListView<Pedidos> listView;
    private ObservableList<Pedidos> lista_listView;
    @FXML
    private ComboBox<Pizza> combo;
    private ObservableList<Pizza> listaCombo;
    @FXML
    private TextField textoNombre, textoTelefono;
    @FXML
    private RadioButton radioFamiliar, radioIndividual, radioMediana;
    private ToggleGroup grupoRadios;
    private ArrayList<String> bbq;
    private ArrayList<String> quesos;
    private ArrayList<String> hawai;
    private ArrayList<String> jyq;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarRadios();
        acciones();
    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll(
                new Pizza("Barbacoa"),
                new Pizza("Hawaiana"),
                new Pizza("Jamon y Queso"),
                new Pizza("Cuatro Quesos"));
        combo.setItems(listaCombo);
        grupoRadios = new ToggleGroup();
        bbq = new ArrayList<>();
        hawai = new ArrayList<>();
        jyq = new ArrayList<>();
        quesos = new ArrayList<>();
        rellenarPizzas();
        lista_listView = FXCollections.observableArrayList();
    }

    private void rellenarPizzas() {
        bbq.add("bacon");
        bbq.add("salsa barbacoa");
        bbq.add("maiz");
        bbq.add("cebolla");
        bbq.add("carne");
        //----------------
        hawai.add("piña");
        hawai.add("jamon");
        hawai.add("salsa");
        //----------------
        jyq.add("queso");
        jyq.add("jamon");
        //---------------
        quesos.add("queso gorgonzola");
        quesos.add("queso parmesano");
        quesos.add("queso roquefort");
        quesos.add("queso gouda");
    }

    private void personalizarRadios() {
        grupoRadios.getToggles().addAll(radioIndividual, radioMediana, radioFamiliar);
    }

    private void acciones() {
        itemCaja.setOnAction(this);
        itemRealizar.setOnAction(this);
        itemServir.setOnAction(this);
        botonRealizar.setOnAction(this);
        botonServir.setOnAction(this);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (textoNombre.getText().isEmpty() || textoTelefono.getText().isEmpty() || grupoRadios.getSelectedToggle() == null || combo.getSelectionModel().getSelectedIndex() == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Por favor introduzca todos los datos");
            alert.show();
        } else {
            if (actionEvent.getSource() == itemRealizar || actionEvent.getSource() == botonRealizar) {
                int contador = 0;
                contador++;
                //PIZZA BBQ
                if (combo.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("barbacoa")) {
                    //TAMAÑOS
                    if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("individual")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        7, bbq));
                        addremove(pedidos);
                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("mediana")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        12, bbq));
                        addremove(pedidos);
                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("familiar")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        15, bbq));
                        addremove(pedidos);
                    }
                    //PIZZA HAW
                } else if (combo.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("hawaiana")) {
                    //TAMAÑOS
                    if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("individual")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        5, hawai));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("mediana")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        10, hawai));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("familiar")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        13, hawai));
                        addremove(pedidos);

                    }
                    //jamonqueso
                } else if (combo.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("Jamon y Queso")) {
                    //TAMAÑOS
                    if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("individual")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        4, jyq));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("mediana")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        8, jyq));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("familiar")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        10, jyq));
                        addremove(pedidos);

                    }
                    //4quesos
                } else if (combo.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("cuatro quesos")) {
                    //TAMAÑOS
                    if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("individual")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        8, quesos));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("mediana")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        13, quesos));
                        addremove(pedidos);

                    } else if (((RadioButton) grupoRadios.getSelectedToggle()).getText().equalsIgnoreCase("familiar")) {
                        pedidos = new Pedidos(contador, textoNombre.getText(), textoTelefono.getText(),
                                new Pizza(combo.getSelectionModel().getSelectedItem().getNombre(),
                                        ((RadioButton) grupoRadios.getSelectedToggle()).getText(),
                                        17, quesos));
                        addremove(pedidos);

                    }
                }

            } else if (actionEvent.getSource() == itemServir || actionEvent.getSource() == botonServir) {

            } else if (actionEvent.getSource() == itemCaja) {

            }
        }


    }

    private void addremove(Pedidos p) {
        lista_listView.add(p);
        listView.setItems(lista_listView);
        textoTelefono.clear();
        textoNombre.clear();
        combo.getSelectionModel().select(-1);
        grupoRadios.getSelectedToggle().setSelected(false);
        listView.getSelectionModel().select(-1);
    }


}