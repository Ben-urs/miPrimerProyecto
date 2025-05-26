package com.decroly.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class PaginaPrincipalController implements Initializable {

    @FXML
    private DatePicker fechaSalida;

    @FXML
    private DatePicker fechaVuelta;

    @FXML
    private ComboBox<String> comboPasajeros;

    @FXML
    private ComboBox<String> comboClase;

    @FXML
    private DatePicker fechaSalidaIda;

    @FXML
    private ComboBox<String> comboPasajerosIda;

    @FXML
    private ComboBox<String> comboClaseIda;


    // Tabla

    @FXML
    private TableView<vuelos> tablaVuelos;

    @FXML
    private TableColumn<vuelos, Integer> colIdVuelo, colOrigen, colDestino, colPrecio, colAerolinea;

    @FXML
    private TableColumn<vuelos, LocalDateTime> colSalida, colLlegada;

    @FXML
    ObservableList<vuelos> observableListVuelos = FXCollections.observableArrayList();


    // ComboBox

    @FXML
    private ComboBox<String> idaVuelta_desdeCombo;

    @FXML
    public void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Página principal cargada correctamente");

        Connection conn = DataConnect.getConnection();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM paises")) {
            while (rs.next()) {
                String pais = rs.getString("nombre");
                idaVuelta_desdeCombo.getItems().add(pais);
            }
        } catch (Exception e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
    }
}