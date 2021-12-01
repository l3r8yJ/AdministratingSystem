package com.example.uifxmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.company.Data.LocalEmployeesList;
import com.company.Employees.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeLoginController {
    private void createEmployeePage(Employee employee) {
        Stage stage = new Stage();
        stage.setTitle("Your page");
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EmployeePage-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField phoneInput;

    @FXML
    void initialize() {
        String fileName = "employees.csv";
        LocalEmployeesList employeesDB = new LocalEmployeesList(fileName);
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");

        loginButton.setOnAction(actionEvent -> {
            Employee e = employeesDB.getEmployee(passwordInput.getText(), phoneInput.getText());
            createEmployeePage(e);
        });

        phoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) phoneInput.setText(oldValue);
        });
    }

}
