package com.example.practicajson2;

import com.example.practicajson2.model.BebidasJSON;
import com.google.gson.Gson;
import javafx.application.Platform;
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
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private ChoiceBox<String> choiceIngre;
    private ObservableList<String> listaChoice;
    @FXML
    private TableColumn<?, ?> columnId, columnName;
    @FXML
    private ComboBox<String> comboAlcohol;
    private ObservableList<String> listaCombo;
    @FXML
    private ListView<BebidasJSON> listaBebidas;
    private ObservableList<BebidasJSON> listalistView;

    @FXML
    private Spinner<Integer> spinnerCantidad;
    private SpinnerValueFactory<Integer> listaSpinner;
    @FXML
    private TableView<BebidasJSON> tablaBebidas;
    private ObservableList<BebidasJSON> listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        setDatosTabla();
        acciones();
    }

    private void setDatosTabla() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("idDrink"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("strDrink"));
    }

    public void getBebidas(String alcohol) {
        try {
            listaTabla.clear();
            URL url = new URL("https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=" + alcohol);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadoBebidas = jsonObject.getJSONArray("drinks");

            for (int i = 0; i < resultadoBebidas.length(); i++) {
                JSONObject bebida = resultadoBebidas.getJSONObject(i);
                Gson gson = new Gson();
                BebidasJSON bebidasJSON = gson.fromJson(String.valueOf(bebida),BebidasJSON.class);

                listaTabla.add(bebidasJSON);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void getIngredientes(String ing){
        listalistView.clear();
        try {
            URL url = new URL("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i="+ing);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea = reader.readLine())!= null){
                stringBuffer.append(linea);
            }

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadosBebidas = jsonObject.getJSONArray("drinks");

            for (int i =0; i <resultadosBebidas.length(); i++){
                JSONObject bebida = resultadosBebidas.getJSONObject(i);
                Gson gson = new Gson();
                BebidasJSON bebidasJSON = gson.fromJson(String.valueOf(bebida), BebidasJSON.class);
                listalistView.add(bebidasJSON);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void acciones() {
        botonDetalle1.setOnAction(this);
        botonDetalle2.setOnAction(this);

        comboAlcohol.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1 != null){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            getBebidas(t1);
                        }
                    });
                }
            }
        });

        choiceIngre.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1!=null){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            getIngredientes(t1);
                        }
                    });
                }
            }
        });
    }

    private void instancias() {

        //COMBO

        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Alcoholic", "Non_Alcoholic");
        comboAlcohol.setItems(listaCombo);

        //SPINNER 295

        listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 295, 1, 10);
        spinnerCantidad.setValueFactory(listaSpinner);

        //CHOICE

        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("Light rum", "Applejack", "Gin", "Dark rum", "Sweet Vermouth", "Strawberry schnapps", "Scotch", "Apricot brandy", "Triple sec", "Southern Comfort", "Orange bitters", "Brandy", "Lemon vodka", "Blended whiskey", "Dry Vermouth", "Amaretto", "Tea", "Champagne", "Coffee liqueur", "Bourbon", "Tequila", "Vodka", "Añejo rum", "Bitters", "Sugar", "Kahlua", "demerara Sugar", "Dubonnet Rouge", "Watermelon", "Lime juice", "Irish whiskey", "Apple brandy", "Carbonated water", "Cherry brandy", "Creme de Cacao", "Grenadine", "Port", "Coffee brandy", "Red wine", "Rum", "Grapefruit juice", "Ricard", "Sherry", "Cognac", "Sloe gin", "Apple juice", "Pineapple juice", "Lemon juice", "Sugar syrup", "Milk", "Strawberries", "Chocolate syrup", "Yoghurt", "Mango", "Ginger", "Lime", "Cantaloupe", "Berries", "Grapes", "Kiwi", "Tomato juice", "Cocoa powder", "Chocolate", "Heavy cream", "Galliano", "Peach Vodka", "Ouzo", "Coffee", "Spiced rum", "Water", "Espresso", "Angelica root", "Orange", "Cranberries", "Johnnie Walker", "Apple cider", "Everclear", "Cranberry juice", "Egg yolk", "Egg", "Grape juice", "Peach nectar", "Lemon", "Firewater", "Lemonade", "Lager", "Whiskey", "Absolut Citron", "Pisco", "Irish cream", "Ale", "Chocolate liqueur", "Midori melon liqueur", "Sambuca", "Cider", "Sprite", "7-Up", "Blackberry brandy", "Peppermint schnapps", "Creme de Cassis");
        choiceIngre.setItems(listaChoice);

        //TABLA

        listaTabla = FXCollections.observableArrayList();
        tablaBebidas.setItems(listaTabla);

        //LISTVIEW

        listalistView = FXCollections.observableArrayList();
        listaBebidas.setItems(listalistView);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonDetalle1) {
            Dialog dialog = new Dialog();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detalle1-view.fxml"));
            try {
                Parent root = null;
                root = loader.load();
                dialog.getDialogPane().setContent(root);
                Detalle1Controller controller = loader.getController();
                controller.setDetalles(tablaBebidas.getSelectionModel().getSelectedItem());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialog.getDialogPane().getButtonTypes().setAll(ButtonType.CLOSE);
            dialog.show();

        } else if (actionEvent.getSource() == botonDetalle2) {
            Dialog dialog = new Dialog();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detalle1-view.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                dialog.getDialogPane().setContent(root);
                Detalle1Controller controller = loader.getController();
                controller.setDetalles(listaBebidas.getSelectionModel().getSelectedItem());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialog.getDialogPane().getButtonTypes().setAll(ButtonType.CLOSE);
            dialog.show();


        }
    }
}