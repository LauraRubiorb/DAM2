package com.example.practicajson;

import com.example.practicajson.model.CategoriasJSON;
import com.example.practicajson.model.ComidasJSON;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonDetalle1, botonDetalle2;
    @FXML
    private MenuItem menuSalir;
    @FXML
    private TableColumn<?, ?> columnId, columnNombre;
    @FXML
    private ComboBox<String> comboCategoria;
    private ObservableList<String> listaCombo;
    @FXML
    private ListView<ComidasJSON> listaComidas;
    private ObservableList<ComidasJSON> listViewComidas;
    @FXML
    private Spinner<Integer> spinnerComidas;
    private SpinnerValueFactory<Integer> listaSpinner;
    @FXML
    private TableView<CategoriasJSON> tablaCategorias;
    private ObservableList<CategoriasJSON> listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
        configurarTabla();
    }

    private void configurarTabla() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("strCategory"));
    }

    private void getCategorias(int valor) {
        try {
            listaTabla.clear();
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/categories.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadoCategorias = jsonObject.getJSONArray("categories");

            for (int i = 0; i < valor && i < resultadoCategorias.length(); i++) {
                JSONObject categoria = resultadoCategorias.getJSONObject(i);
                Gson gson = new Gson();
                CategoriasJSON categoriasJSON = gson.fromJson(String.valueOf(categoria), CategoriasJSON.class);

                listaTabla.add(categoriasJSON);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getComidas(String categoria) {
        listViewComidas.clear();
        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/filter.php?c=" + categoria);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadoComida = jsonObject.getJSONArray("meals");

            for (int i = 0; i < resultadoComida.length(); i++) {
                JSONObject comidas = resultadoComida.getJSONObject(i);
                Gson gson = new Gson();
                ComidasJSON comidasJSON = gson.fromJson(String.valueOf(comidas), ComidasJSON.class);

                listViewComidas.add(comidasJSON);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void instancias() {

        //LISTA TABLA

        listaTabla = FXCollections.observableArrayList();
        tablaCategorias.setItems(listaTabla);

        //LISTA DEL COMBO

        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Beef", "Chicken", "Dessert", "Lamb", "Miscellaneous", "Pasta", "Pork", "Seafood", "Side",
                "Starter", "Vegan", "Vegetarian", "Breakfast", "Goat");
        comboCategoria.setItems(listaCombo);

        //LISTA SPINNER:

        listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 14);
        spinnerComidas.setValueFactory(listaSpinner);

        //LISTA LISTVIEW

        listViewComidas = FXCollections.observableArrayList();
        listaComidas.setItems(listViewComidas);


    }

    private void acciones() {
        menuSalir.setOnAction(this);
        botonDetalle1.setOnAction(this);
        botonDetalle2.setOnAction(this);

        //FILTRAR SPINNER

        spinnerComidas.valueProperty().addListener((observable, oldValue, newValue) -> {
            getCategorias(newValue);
        });

        //FILTRAR COMBO
        comboCategoria.setOnAction(event -> {
            String categoriaSeleccionada = comboCategoria.getSelectionModel().getSelectedItem();
            if (categoriaSeleccionada != null) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        getComidas(categoriaSeleccionada);
                    }
                });
            }
        });

    }


    @Override
    public void handle(ActionEvent actionEvent) {
//MENU SALIR
        if (actionEvent.getSource() == menuSalir) {
            System.exit(0);
        }
//BOTON DETALLE 1
        else if (actionEvent.getSource() == botonDetalle1) {
            if (tablaCategorias.getSelectionModel().getSelectedIndex() != -1) {
                Dialog dialog = new Dialog();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detalleCategorias-view.fxml"));
                    Parent root = null;
                    root = loader.load();
                    dialog.getDialogPane().setContent(root);
                    DetalleCategoriasController detalle = loader.getController();
                    detalle.setDetallesCategory(tablaCategorias.getSelectionModel().getSelectedItem());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dialog.getDialogPane().getButtonTypes().setAll(ButtonType.CLOSE);
                dialog.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No has seleccionado datos");
                alert.show();
            }

        }
//BOTON DETALLE 2
        else if (actionEvent.getSource() == botonDetalle2) {
            if (listaComidas.getSelectionModel().getSelectedIndex() != -1) {
                Dialog dialog = new Dialog();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detalleComida-view.fxml"));
                    Parent root = null;
                    root = loader.load();
                    dialog.getDialogPane().setContent(root);
                    DetalleComidaController detalle = loader.getController();
                    detalle.setDetalleComida(listaComidas.getSelectionModel().getSelectedItem());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dialog.getDialogPane().getButtonTypes().setAll(ButtonType.CLOSE);
                dialog.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No has seleccionado datos");
                alert.show();
            }
        }
    }
}