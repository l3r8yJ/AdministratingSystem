package com.example.uifxmenu;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EmployeeLoginController {

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
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        phoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) phoneInput.setText(oldValue);
        });
    }

}
