package com.decroly.demo;

import com.decroly.demo.DataConnect;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MostrarPaisesEnComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Conectar a la base de datos
        Connection conn = DataConnect.getConnection();

        // Crear un ComboBox
        ComboBox<String> comboBox = new ComboBox<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM paises")) {

            // Leer los países de la base de datos
            while (rs.next()) {
                String pais = rs.getString("nombre");
                comboBox.getItems().add(pais);
            }

        } catch (Exception e) {
            System.out.println("Error al leer los países" + e.getMessage());
        }

        // Crear la interfaz gráfica
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(comboBox);

        // Mostrar la interfaz gráfica
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mostrar Países en ComboBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}