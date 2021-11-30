package com.example.uifxmenu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import com.company.Employees.Employee;
import com.company.Data.LocalEmployeesList;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        listOfEmployees.setItems(FXCollections.observableList(employeesDB.getEmployeeList()));

        listOfEmployees.setCellFactory(param -> new ListCell<Employee>() {
            @Override
            protected void updateItem(Employee item, boolean empty) {
                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
    }
//    public void handleMouseClick(MouseEvent mouseEvent) {
//        listOfEmployees.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                if(listOfEmployees.getSelectionModel().getSelectedItem() != null)
//                System.out.println("clicked on " + listOfEmployees.getSelectionModel().getSelectedItem().getName());
//            }
//        });
//    }
}
