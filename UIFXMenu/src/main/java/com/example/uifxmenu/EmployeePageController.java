package com.example.uifxmenu;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.Employees.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jetbrains.annotations.NotNull;

public class EmployeePageController {
    Employee settledEmployee;

    public void setInitData(@NotNull Employee employee) {
        settledEmployee = employee;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button endButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label nameLabel1;

    @FXML
    private Label salaryLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Button startButton;

    @FXML
    private Label workedTimeLabel;

    @FXML
    void initialize() {
        nameLabel.setText(settledEmployee.getName());
        nameLabel1.setText(settledEmployee.getName());
        passwordLabel.setText(settledEmployee.getPassword());
        phoneLabel.setText(settledEmployee.getPhoneNumber());
        workedTimeLabel.setText(settledEmployee.getWorkedTime() + " hours");
        salaryLabel.setText(settledEmployee.getSalary() + " roubles");
    }
}
