module com.example.uifxmenu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.company;

    opens com.example.uifxmenu to javafx.fxml;
    exports com.example.uifxmenu;
    uses com.company.Data.LocalEmployeesList;
}