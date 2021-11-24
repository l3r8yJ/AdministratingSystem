package Interactions;
import Employees.*;
import Data.*;

import java.util.Date;
import java.util.Scanner;

public class ConsoleMenu {

    LocalEmployeesList localEmployeesDB = new LocalEmployeesList();
    String employeesDataBaseFile = "employees.csv";
    String workReportFile = "workReport.txt";
    Scanner scanner = new Scanner(System.in);
    int selector;
    String adminPassword = "root";

    public void MainMenu(){
        while (true)
        {
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
                    localEmployeesDB.Clear();
                    localEmployeesDB.ImportFromFile(employeesDataBaseFile);
                    AdminLogin();
                    break;
                case 2:
                    EmployeeLogin();
                    break;
                case 3:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector);
            }
        }
    }

    private void AdminLogin() {
        System.out.println("Enter password: ");
        var admPass = scanner.next();
        if (admPass.equals(adminPassword)) AdminRun();
        else System.out.println("wrong password!");
    }

    private void EmployeeLogin() {
        boolean phoneFound = false;
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        for (var e : localEmployeesDB.getEmployeeList()){
            if (phoneNumber.equals(e.getPhoneNumber())) {
                phoneFound = true;
                for (int i = 2; i >= 0; i--) {
                    System.out.println("Enter password: ");
                    String password = scanner.next();
                    if (password.equals(e.getPassword())){
                        System.out.println("You're welcome!");
                        EmployeeRun(e);
                        return;
                    }
                    else {
                        System.out.println("Wrong password!");
                        System.out.println("Attempts left: " + i);
                    }
                }
            }
        }
        if (!phoneFound)
            System.out.println("Phone number not found...");
    }

    private void EmployeeRun(Employee temp) {

        System.out.println("You logged as " + temp.getName());
        System.out.println("1. The beginning of the work day.");
        System.out.println("2. End of the working day.");
        System.out.println("3. Exit.");


        var reader = scanner.next();

        try {
            selector = Integer.parseInt(reader);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input" + e);
        }

        switch (selector) {
            case 1:
                Date inDate = new Date();
                temp.setTimeOfBeginning(inDate.getHours());
                System.out.println("Start of work at " + inDate.getHours() + " added.");
                Sleep();
                break;

                case 2:
                    Date outDate = new Date();
                    temp.setTimeOfShutdown(outDate.getHours());
                    System.out.println("End of work at " + outDate.getHours()  + " added.");
                    temp.addWorkedTime();
                    System.out.println("You totally worked " + temp.getWorkedTime());
                    localEmployeesDB.ExportToFile(employeesDataBaseFile);
                    Sleep();
                    break;

                    case 3:
                        Sleep();
                        return;

                        default:
                        throw new IllegalStateException("Unexpected value" + selector);
                }
    }

    private void AdminRun() {
        while (true)
        {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Show list of employees.");
            System.out.println("2. Add employee to list.");
            System.out.println("3. Remove employee from list.");
            System.out.println("4. Create work report.");
            System.out.println("5. Exit.");

            var reader = scanner.next();

            try {
                selector = Integer.parseInt(reader);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input" + e);
            }

            switch (selector) {
                case 1:
                    localEmployeesDB.ConsolePrint();
                    break;
                case 2:
                    MenuAdd();
                    break;
                case 3:
                    MenuRemove();
                    break;
                case 4:
                    localEmployeesDB.MakeReport(workReportFile);
                    break;
                case 5:
                    localEmployeesDB.ExportToFile(employeesDataBaseFile);
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

        return new Employee(name, phoneNumber, password, 0);
    }

    private void MenuAdd() {
        System.out.println("Select the type of employee:");
        System.out.println("1. Employee on salary");
        System.out.println("2. Freelancer");
        var reader = scanner.next();
        try {
            selector = Integer.parseInt(reader);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input" + e);
        }
        var tmp = fillForEmployee();
        switch (selector) {
            case 1:
                localEmployeesDB.AddEmployee(new EmployeeOnSalary(tmp.getName(), tmp.getPhoneNumber(), tmp.getPassword(), tmp.getWorkedTime()));
                break;
            case 2:
                localEmployeesDB.AddEmployee(new Freelancer(tmp.getName(), tmp.getPhoneNumber(), tmp.getPassword()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selector);
        }
        System.out.println("Employee added successfully");
    }

    private void MenuRemove() {
        System.out.println("Phone number: ");
        Scanner read = new Scanner(System.in);
        var phoneNumber = read.next();
        localEmployeesDB.DeleteEmployee(phoneNumber);
    }

    private void Sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
