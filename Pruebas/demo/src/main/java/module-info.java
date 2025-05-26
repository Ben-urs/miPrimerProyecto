module com.decroly.demo {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.decroly.demo to javafx.fxml;
    exports com.decroly.demo;
}