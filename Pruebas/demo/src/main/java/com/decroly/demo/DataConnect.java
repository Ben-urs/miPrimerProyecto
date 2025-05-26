package com.decroly.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import javafx.scene.control.ComboBox;

public class DataConnect {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String dataBaseName = "orbitravel";
        String dataBaseUser = "developer";
        String dataBasePassword = "developer";
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            databaseLink = DriverManager.getConnection(url+dataBaseName, dataBaseUser, dataBasePassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver" + e.getMessage());
        }catch (Exception e) {
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return databaseLink;
    }




//    public LinkedList<vuelos> getListaVuelos() {
//        LinkedList<vuelos> lista = new LinkedList<>();
//
//        String getComando = "SELECT * FROM vuelos";
//
//        try(Connection connection = DataConnect.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(getComando);) {
//            while (resultSet.next()) {
//
//                int vuelo  = resultSet.getInt("vuelo_id");
//                int origen = resultSet.getInt("origen_id");
//                int destino = resultSet.getInt("destino_id");
//                LocalDate salidafecha = resultSet.getTimestamp("salida_fecha").toLocalDateTime();
//                LocalDate llegadafecha = resultSet.getTimestamp("llegada_fecha").toLocalDateTime();
//                double preciobase = resultSet.getDouble("precio_base");
//                int aerolineaid = resultSet.getInt("aerolinea_id");
//
//            }
//            } catch (Exception e) {
//            System.out.println("Error al obtener la lista de vuelos" + e.getMessage());
//        }
//
//
//
//        return lista;
//    }



}