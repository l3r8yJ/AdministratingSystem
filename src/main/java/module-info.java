module com.company {
    //requires org.jetbrains.annotations;
    opens com.company.Data to com.example.uifxmenu;
    opens com.company.Employees to com.example.uifxmenu;
    exports com.company.Data;
    exports com.company.Employees;
}