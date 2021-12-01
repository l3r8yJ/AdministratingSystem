package com.example.uifxmenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import com.company.Employees.Employee;
import com.company.Data.LocalEmployeesList;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class AdminPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button createReportButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label listLabel;

    @FXML
    private ListView<Employee> listOfEmployees;

    @FXML
    void initialize(){
        String fileName = "employees.csv";
        LocalEmployeesList employeesDB = new LocalEmployeesList();
        employeesDB.ImportFromFile(fileName);
        listOfEmployees.getItems().setAll(employeesDB.getEmployeeList());

//        listOfEmployees.setCellFactory(param -> new ListCell<Employee>() {
//            @Override
//            protected void updateItem(Employee item, boolean empty) {
//                if (empty || item == null || item.getName() == null) {
//                    setText(null);
//                } else {
//                    setText(item.getName());
//                }
//            }
//        });

        listOfEmployees.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {
            @Override
            public void changed(ObservableValue<? extends Employee> observableValue, Employee employee, Employee t1) {
                ShowPageController spc = new ShowPageController();
                Stage stage = new Stage();
                Employee emp = listOfEmployees.getSelectionModel().getSelectedItem();
                spc.setInitData(emp);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("ShowPage-view.fxml"));
                loader.setController(spc);
                Scene scene = null;
                try {
                    scene = new Scene(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setResizable(false);
                stage.setTitle("EmployeeView");
                stage.setScene(scene);
                stage.show();
            }
        });
    }
}
