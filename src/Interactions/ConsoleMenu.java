package Interactions;
import Employees.*;
import Data.*;
import java.util.Scanner;

public class ConsoleMenu {

    LocalEmployeesList employeesList = new LocalEmployeesList();
    String employeesDataBaseFile = "employees.csv";
    Scanner scanner = new Scanner(System.in);
    int selector;

    public void MainMenu(){
        while (true)
        {
            System.out.println();
            System.out.println("Who you are?");
            System.out.println("1. Administrator.");
            System.out.println("2. Employee.");
            System.out.println("3. Exit");

            var reader = scanner.next();

            try {
                selector = Integer.parseInt(reader);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input" + e);
            }

            switch (selector) {
                case 1:
                    AdministrationRun();
                    break;
                case 2:
                    EmployeeRun();
                    break;
                case 3:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector);
            }
        }
    }

    private void EmployeeRun() {}

    private void AdministrationRun() {
        employeesList.Clear();
        employeesList.ImportFromFile(employeesDataBaseFile);
        while (true)
        {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Show list of employees.");
            System.out.println("2. Add employee to list.");
            System.out.println("3. Remove employee from list.");
            System.out.println("4. Exit.");

            var reader = scanner.next();

            try {
                selector = Integer.parseInt(reader);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input" + e);
            }

            switch (selector) {
                case 1:
                    employeesList.ConsolePrint();
                    break;
                case 2:
                    MenuAdd();
                    break;
                case 3:
                    MenuRemove();
                    break;
                case 4:
                    employeesList.ExportToFile(employeesDataBaseFile);
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector);
            }
        }
    }

    private Employee fillForEmployee() {
        String name;
        String phoneNumber;
        String password;
        Scanner read = new Scanner(System.in);

        System.out.println("Name: ");
        name = read.nextLine();

        System.out.println("Phone number: ");
        phoneNumber = read.next();

        System.out.println("Password: ");
        password = read.next();

        return new Employee(name, phoneNumber, password);
    }

    private void MenuAdd() {
        var tmp = fillForEmployee();
        employeesList.AddEmployee(new Employee(tmp.getName(), tmp.getPhoneNumber(), tmp.getPassword()));
    }

    private void MenuRemove() {
        System.out.println("Phone number: ");
        Scanner read = new Scanner(System.in);
        var phoneNumber = read.next();
        employeesList.DeleteEmployee(phoneNumber);
    }
}
