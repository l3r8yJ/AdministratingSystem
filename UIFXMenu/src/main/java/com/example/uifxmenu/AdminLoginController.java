package com.example.uifxmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import Data.LocalEmployeesList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class AdminLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passField;

    @FXML
    private Button loginButton;

    @FXML
    private Label passLabel;

    @FXML
    void initialize() {
        loginButton.setOnAction(actionEvent -> {
            if (passField.getText().equals("root")) {
                Stage stage = new Stage();
                stage.setTitle("Administration");
                stage.setResizable(false);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AdminPage-view.fxml"));
                Scene scene;
                try {
                    scene = new Scene(loader.load(), 270, 800);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.show();
            } else System.out.println("wrong pass!");
        });
    }

}
