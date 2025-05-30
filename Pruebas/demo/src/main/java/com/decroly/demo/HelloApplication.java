package com.decroly.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1820, 980); // Tamaño como en tu FXML
        stage.setTitle("OrbiTravel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        // Verificación de conexión
        DataConnect dataConnect = new DataConnect();
        Connection conn = dataConnect.getConnection();

        if (conn != null) {
            System.out.println("Conexión exitosaaaa.");
            launch(args);
        } else {
            System.out.println("Error al conectar con la base de datos. Cerrando aplicación...");
        }
    }
}

