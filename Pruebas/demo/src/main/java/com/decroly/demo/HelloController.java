package com.decroly.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable{



    @FXML
    private VBox registroPanel;

    @FXML
    private VBox iniciosesionPanel;

    @FXML
    private javafx.scene.control.Button flechaRegreso;

    @FXML
    private javafx.scene.control.Button loginButton;

    @FXML
    private Label registrarseField;


    // === LOGIN ===
    @FXML
    private TextField emailUserLogin;
    @FXML
    private PasswordField passwordUserLogin;
    @FXML
    private Label welcomeText;


    // == REGISTRO ==
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private DatePicker fechaNacimientoField;
    @FXML
    private PasswordField contraField;
    @FXML
    private PasswordField repiteContraField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telefonoField;

    @FXML
    private Label welcomeText2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Mostrar solo el panel de inicio de sesión al inicio
        iniciosesionPanel.setVisible(true);
        registroPanel.setVisible(false);

        // Acción al hacer clic en "Registrate"
        registrarseField.setOnMouseClicked(event -> {
            iniciosesionPanel.setVisible(false);
            registroPanel.setVisible(true);

            // Accion volver para atras
            flechaRegreso.setOnMouseClicked(event1->{
                iniciosesionPanel.setVisible(true);
                registroPanel.setVisible(false);
            });
        });
    }



    @FXML
    protected void onLoginButtonClick() {
        String username = emailUserLogin.getText();
        String password = passwordUserLogin.getText();

        if (validateLogin(username, password)) {
            welcomeText.setText("¡Inicio de sesión exitoso!");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PaginaPrincipal.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1820, 980);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            welcomeText.setText("Usuario o contraseña incorrectos.");
        }
    }



    private boolean validateLogin(String username, String password) {
        DataConnect connect = new DataConnect();
        Connection connection = connect.getConnection();

        try {
            // CORREGIDO: Cambié 'contrasena' por 'contraseña' para coincidir con la BD
            String query = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contraseña = ?";
            var statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            var resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onRegistroButton() {
        String nombreRegistro = nombreField.getText();
        String apellidoRegistro = apellidoField.getText();
        String emailRegistro = emailField.getText();
        LocalDate fechaNacimientoRegistro = fechaNacimientoField.getValue();
        String telefonoRegistro = telefonoField.getText();
        String contraRegistro = contraField.getText();
        String repiteContraRegistro = repiteContraField.getText();

        // Validar que todos los campos estén completos
        if (nombreRegistro.isEmpty() || apellidoRegistro.isEmpty() || emailRegistro.isEmpty() ||
                fechaNacimientoRegistro == null || contraRegistro.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText("Por favor complete todos los campos obligatorios.");
            alert.showAndWait();
            return;
        }

        if (!contraRegistro.equals(repiteContraRegistro)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseñas no coinciden");
            alert.setHeaderText("Las contraseñas no coinciden, vuelva a intentarlo.");
            alert.showAndWait();
            return;
        }

        if (!(GmailValidator.isValidGmail(emailRegistro))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Correo no valido");
            alert.setHeaderText("El correo no es valido, solo se admiten correos con este formato: " +
                    ".......@gmail.com");
            alert.showAndWait();
            return;
        }

        boolean registroExitoso = validadorRegistro(
                nombreRegistro,
                apellidoRegistro,
                emailRegistro,
                fechaNacimientoRegistro,
                telefonoRegistro,
                contraRegistro
        );

        if (registroExitoso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("✅");
            alert.setContentText("Registro exitoso");
            alert.showAndWait();

            // Limpiar los campos después del registro exitoso
            nombreField.clear();
            apellidoField.clear();
            emailField.clear();
            fechaNacimientoField.setValue(null);
            telefonoField.clear();
            contraField.clear();
            repiteContraField.clear();

            // Volver al panel de login
            iniciosesionPanel.setVisible(true);
            registroPanel.setVisible(false);
        } else {
            welcomeText2.setText("¡Error al registrarse!");
        }
    }


    private boolean validadorRegistro(String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono, String contrasena) {
        DataConnect connect = new DataConnect();
        Connection connection = connect.getConnection();

        try {
            // CORREGIDO: Necesitas generar un ID único para el usuario
            // Primero obtener el próximo ID disponible
            String queryMaxId = "SELECT COALESCE(MAX(usuario_id), 0) + 1 as next_id FROM usuarios";
            var statementMaxId = connection.prepareStatement(queryMaxId);
            var resultSetMaxId = statementMaxId.executeQuery();

            int nextId = 1;
            if (resultSetMaxId.next()) {
                nextId = resultSetMaxId.getInt("next_id");
            }

            // CORREGIDO: Cambié 'contrasena' por 'contraseña' y agregué usuario_id
            String query = "INSERT INTO usuarios (usuario_id, nombre, apellido, correo_electronico, fecha_nacimiento, telefono, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
            var statement = connection.prepareStatement(query);

            statement.setInt(1, nextId);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, email);
            statement.setDate(5, java.sql.Date.valueOf(fechaNacimiento));
            statement.setString(6, telefono);
            statement.setString(7, contrasena);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}