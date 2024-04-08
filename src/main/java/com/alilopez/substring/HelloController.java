package com.alilopez.substring;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import com.fasterxml.uuid.Generators;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private PieChart chart;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtId;

    @FXML
    private ComboBox<String> cbUuid;

    @FXML
    void onMouseClickedBtnBuscar(MouseEvent event) {
        boolean status = false;
        int index = 0;
        while (!status && index < cbUuid.getItems().size()) {
            System.out.println(cbUuid.getItems().get(index).indexOf(txtId.getText()));
            if (cbUuid.getItems().get(index).indexOf(txtId.getText()) >= 0 ) {
                status = true;
                System.out.println("Encontrado el uuid: " + cbUuid.getItems().get(index));
            }
            index++;
        }
    }

    @FXML
    void onMouseClickedBtnagregar(MouseEvent event) {
        UUID uuid = Generators.timeBasedGenerator().generate();
        cbUuid.getItems().add(uuid.toString());
    }

    @FXML
    void initialize() {

    }

    @FXML
    void onMouseBtnChart(MouseEvent event) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13.5),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 21.5),
                        new PieChart.Data("Apples", 30));

        chart.setData(pieChartData);
        chart.setTitle("Mi gráfica");
    }

}
