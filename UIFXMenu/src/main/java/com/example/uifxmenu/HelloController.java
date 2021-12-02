package com.example.uifxmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.company.Data.LocalEmployeesList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminButton;

    @FXML
    private Button empButton;

    @FXML
    void initialize() {
        adminButton.setOnAction(actionEvent -> {System.out.println("Admin button was pressed!");
            Stage stage = new Stage();
            stage.setTitle("Admin login");
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AdminLogin-view.fxml"));
            Scene scene;
            try {
                scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();
        });
        empButton.setOnAction(actionEvent -> {
            System.out.println("Employee button was pressed!");
            Stage stage = new Stage();
            stage.setTitle("Employee login");
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EmployeeLogin-view.fxml"));
            Scene scene;
            try {
                scene = new Scene(loader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();
        });
    }

}
