package com.example.uifxmenu;

import java.net.URL;
import java.util.ResourceBundle;
import com.company.Employees.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button closeButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label workedLabel;

    @FXML
    void initialize() {
        if (settledEmployee.getName() != null && settledEmployee.getPhoneNumber()!= null && settledEmployee.getType() != null) {
            nameLabel.setText(settledEmployee.getName());
            phoneLabel.setText(settledEmployee.getPhoneNumber());
            typeLabel.setText(settledEmployee.getType());
            salaryLabel.setText(settledEmployee.getSalary() + " rubles");
            workedLabel.setText(String.valueOf(settledEmployee.getWorkedTime()));
        }
    }
}
