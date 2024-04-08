module com.alilopez.substring {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.uuid;


    opens com.alilopez.substring to javafx.fxml;
    exports com.alilopez.substring;
}