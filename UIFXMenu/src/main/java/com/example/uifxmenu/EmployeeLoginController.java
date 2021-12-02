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
import org.jetbrains.annotations.NotNull;

public class EmployeeLoginController {

    private void createEmployeePage(Employee employee) {
        EmployeePageController epc = new EmployeePageController();
        Stage stage = new Stage();
        epc.setInitData(employee);
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EmployeePage-view.fxml"));
        loader.setController(epc);
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.setTitle(epc.settledEmployee.getName() + " View");
        stage.setScene(scene);
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
            var password = passwordInput.getText();
            var phone = phoneInput.getText();
            if (password.isEmpty() || phone.isEmpty()) {
                System.out.println("employee not found!");
            } else createEmployeePage(employeesDB.getEmployee(passwordInput.getText(), phoneInput.getText()));
        });

        phoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) phoneInput.setText(oldValue);
        });
    }

}
