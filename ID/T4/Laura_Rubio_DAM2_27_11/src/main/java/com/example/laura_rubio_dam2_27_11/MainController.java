package com.example.laura_rubio_dam2_27_11;

import com.example.laura_rubio_dam2_27_11.model.EquiposJSON;
import com.example.laura_rubio_dam2_27_11.model.PaisesJSON;
import com.google.gson.Gson;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button buttonFiltrar;
    @FXML
    private ImageView imagenEquipo;
    @FXML
    private MenuItem itemDetalles, itemSalir;
    @FXML
    private ListView<EquiposJSON> listaEquipos;
    private ObservableList<EquiposJSON> listViewEquipos;
    @FXML
    private ListView<PaisesJSON> listaPaises;
    private ObservableList<PaisesJSON> listViewPaises;
    @FXML
    private Label nombreEquipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    public void getPaises() {
        try {
            listViewPaises.clear();

            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_countries.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }

            //JSON OBJET Y ARRAY

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadosPaises = jsonObject.getJSONArray("countries");

            //recorrer

            for (int i = 0; i < resultadosPaises.length(); i++) {
                JSONObject pais = resultadosPaises.getJSONObject(i);
                Gson gson = new Gson();
                PaisesJSON paisesJSON = gson.fromJson(String.valueOf(pais).toString(), PaisesJSON.class);

                listViewPaises.add(paisesJSON);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getEquipos(String pais) {
        try {
            listViewEquipos.clear();

            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Soccer&c=" + pais);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }

            //JSON OBJET Y ARRAY

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadoEquipo = jsonObject.getJSONArray("teams");

            //recorrer

            for (int i = 0; i < resultadoEquipo.length(); i++) {
                JSONObject equipo = resultadoEquipo.getJSONObject(i);
                Gson gson = new Gson();
                EquiposJSON equiposJSON = gson.fromJson(String.valueOf(equipo).toString(), EquiposJSON.class);

                listViewEquipos.add(equiposJSON);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void acciones() {
        itemSalir.setOnAction(this);
        itemDetalles.setOnAction(this);
        buttonFiltrar.setOnAction(this);
    }

    private void instancias() {

        //LISTA PAISES

        listViewPaises = FXCollections.observableArrayList();
        listaPaises.setItems(listViewPaises);
        getPaises();

        //LISTA EQUIPOS
        listViewEquipos = FXCollections.observableArrayList();
        listaEquipos.setItems(listViewEquipos);

        accionesEquipo();

    }

    private void accionesEquipo() {
        listaEquipos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EquiposJSON>() {
            @Override
            public void changed(ObservableValue<? extends EquiposJSON> observableValue, EquiposJSON equiposJSON, EquiposJSON t1) {

                imagenEquipo.setImage(new Image(t1.getStrTeamBadge()));
                nombreEquipo.setText(t1.getStrLeague());


            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //ITEM SALIR
        if (actionEvent.getSource() == itemSalir) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Salir");
            alert.setContentText("¿Desea salir?");
            Optional<ButtonType> opciones = alert.showAndWait();
            if (opciones.get() == ButtonType.OK) {
                System.exit(0);
            }

        }
        //ITEM VER DETALLES
        else if (actionEvent.getSource() == itemDetalles) {
            Dialog dialog = new Dialog();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detallesController-view.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                dialog.getDialogPane().setContent(root);
                DetallesController controller = loader.getController();
                EquiposJSON t1 = listaEquipos.getSelectionModel().getSelectedItem();
                if (t1 == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("NO HAY DATOS SELECCIONADOS");
                    alert.show();

                }

                controller.setDetalles(t1);
                dialog.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        //BOTON FILTRAR
        else if (actionEvent.getSource() == buttonFiltrar) {
            PaisesJSON pais = listaPaises.getSelectionModel().getSelectedItem();
            if (pais == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("NO HAY DATOS SELECCIONADOS");
                alert.show();
            } else {
                getEquipos(pais.getName_en());
            }


        }

    }
}