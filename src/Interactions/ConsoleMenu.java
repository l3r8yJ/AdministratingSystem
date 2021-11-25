package Interactions;
import Employees.*;
import Data.*;

import java.util.Date;
import java.util.Scanner;

public class ConsoleMenu {
    int selector;
    LocalEmployeesList localEmployeesDB = new LocalEmployeesList();
    String employeesDataBaseFile = "employees.csv";
    String workReportFile = "workReport.txt";
    String adminPassword = "root";

    public void MainMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            boolean isCorrectValue = false;
            while (!isCorrectValue) {
                System.out.println("Who you are?");
                System.out.println("1. Administrator.");
                System.out.println("2. Employee.");
                System.out.println("3. Exit");

                var reader = scanner.next();

                try {
                    selector = Integer.parseInt(reader);
                } catch (NumberFormatException e) {
                    e.getMessage();
                }

                if(selector > 3 || selector < 1) {
                    System.out.println("Wrong value. \nTry again please.");
                } else {
                    isCorrectValue = true;
                }
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

    private void EmployeeLogin() {
        boolean phoneFound = false;
        Scanner scanner = new Scanner(System.in);
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
                    } else {
                        System.out.println("Wrong password!");
                        System.out.println("Attempts left: " + i);
                    }
                }
            }
        }
        if (!phoneFound) System.out.println("Phone number not found...");
    }

    private void EmployeeRun(Employee temp) {
        Scanner scanner = new Scanner(System.in);

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

    private void AdminLogin() {
        System.out.println("Enter password: ");
        Scanner passScanner = new Scanner(System.in);
        var comparablePassword = passScanner.next();

        if (comparablePassword.equals(adminPassword)) AdminRun();
        else System.out.println("wrong password!");
    }

    private void AdminRun() {
        int adminSelector = 0;
        Scanner aScanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nAdministration mode");
            boolean isCorrectValue = false;

            while (!isCorrectValue) {
                System.out.println("1. Show list of employees.");
                System.out.println("2. Add employee to list.");
                System.out.println("3. Remove employee from list.");
                System.out.println("4. Create work report.");
                System.out.println("5. Exit.");

                var reader = aScanner.next();

                try {
                    adminSelector = Integer.parseInt(reader);
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input" + e);
                }

                if(adminSelector > 5 || adminSelector < 1) {
                    System.out.println("Wrong value. \nTry again please.");
                } else {
                    isCorrectValue = true;
                }
            }
            switch (adminSelector) {
                case 1:
                    localEmployeesDB.ConsolePrint();
                    break;
                case 2:
                    AddEmployee();
                    break;
                case 3:
                    DeleteEmployee();
                    break;
                case 4:
                    localEmployeesDB.createReport(workReportFile);
                    break;
                case 5:
                    localEmployeesDB.ExportToFile(employeesDataBaseFile);
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + adminSelector);
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

        return new Employee(name, phoneNumber, password, 0, "");
    }

    private void AddEmployee() {
        System.out.println("Select the type of employee:");
        System.out.println("1. Employee on salary");
        System.out.println("2. Freelancer");
        Scanner addScanner = new Scanner(System.in);
        var reader = addScanner.next();

        try {
            selector = Integer.parseInt(reader);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input" + e);
        }

        var tmp = fillForEmployee();
        switch (selector) {
            case 1:
                localEmployeesDB.AddEmployee(new EmployeeOnSalary(tmp.getName(), tmp.getPhoneNumber(), tmp.getPassword(), tmp.getWorkedTime(), "Employee on salary"));
                break;
            case 2:
                localEmployeesDB.AddEmployee(new Freelancer(tmp.getName(), tmp.getPhoneNumber(), tmp.getPassword(), tmp.getWorkedTime(), "Freelancer"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selector);
        }
        System.out.println("Employee added successfully");
    }

    private void DeleteEmployee() {
        Scanner read = new Scanner(System.in);
        System.out.println("Are you sure?(Yes/No)");

        if (read.next().toLowerCase().equals("no")) {
            System.out.println("You chooses no");
        } else if (read.next().toLowerCase().equals("yes")){

            System.out.println("Enter phone number: ");
            var phoneNumber = read.next();

            if (localEmployeesDB.DeleteEmployee(phoneNumber)) System.out.println("Employee was deleted!");

            else System.out.println("Employee not found!");

        } else {
            System.out.println("wrong symbols!");
        }
    }

    private void Sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
