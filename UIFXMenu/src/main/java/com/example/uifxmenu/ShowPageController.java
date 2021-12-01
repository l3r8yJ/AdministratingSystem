package com.example.uifxmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.company.Employees.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class ShowPageController {
    Employee settledEmployee;

    public void setInitData(@NotNull Employee employee) {
        settledEmployee = employee;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label atJobLabel;

    @FXML
    private Label atJobLabelBoolean;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label typeLabel;

    @FXML
    void initialize() {
        if (settledEmployee.getName() != null && settledEmployee.getPhoneNumber()!= null && settledEmployee.getType() != null) {
            nameLabel.setText(settledEmployee.getName());
            phoneLabel.setText(settledEmployee.getPhoneNumber());
            typeLabel.setText(settledEmployee.getType());
        }
    }
}
