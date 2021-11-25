package Interactions;
import Employees.*;
import Data.*;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Scanner;

public class ConsoleMenu {
    int selector;
    LocalEmployeesList localEmployeesDB = new LocalEmployeesList();
    String employeesDataBaseFile = "employees.csv";
    String workReportFile = "workReport.txt";
    String adminPassword = "root";

    //Main menu method
    public void MainMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            boolean isCorrectValue = false;
            // menu picker for user types
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

                isCorrectValue = isCorrectValueMethod(reader, 3, selector);
            }

            switch (selector) {
                case 1:
                    //importing DB file
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

    //employees authorization
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
    //part of menu for employees
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
        Calendar calendar = Calendar.getInstance();

        switch (selector) {
            case 1:
                int inDate = calendar.get(Calendar.HOUR);
                temp.setTimeOfBeginning(inDate);
                System.out.println("Start of work at " + inDate + " added.");

                Sleep();
                break;

            case 2:
                int outDate = calendar.get(Calendar.HOUR);
                temp.setTimeOfShutdown(outDate);
                System.out.println("End of work at " + outDate + " added.");
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

    //administrator authorization
    private void AdminLogin() {
        System.out.println("Enter password: ");
        Scanner passScanner = new Scanner(System.in);
        var comparablePassword = passScanner.next();

        if (comparablePassword.equals(adminPassword)) AdminRun();
        else System.out.println("wrong password!");
    }
    //part of menu for administrator
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
                    e.getMessage();
                }

                isCorrectValue = isCorrectValueMethod(reader, 5, adminSelector);
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

    //method for filling employee's data
    private @NotNull Employee fillForEmployee(int selector) {
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

        if (selector == 1) {
            return new EmployeeOnSalary(name, phoneNumber, password, 0, "Employee on salary");
        } else if(selector == 2) {
            return new Freelancer(name, phoneNumber, password, 0, "Freelancer");
        }
        return new Employee() {};
    }


    //add employees to data from menu
    private void AddEmployee() {
        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            System.out.println("Select the type of employee:");
            System.out.println("1. Employee on salary");
            System.out.println("2. Freelancer");

            Scanner addScanner = new Scanner(System.in);
            var reader = addScanner.next();
            int selector = 0;

            try {
                selector = Integer.parseInt(reader);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input" + e);
            }

            isCorrectInput = isCorrectValueMethod(reader, 2, selector);
        }

        var tmp = fillForEmployee(selector);
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
    //delete employees to data from menu
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

    private boolean isCorrectValueMethod(String reader, int lastValue, int selector) {
        boolean isCorrectValue = false;
        if(selector > lastValue || selector < 1) {
            System.out.println("Wrong value. \nTry again please.");
        } else {
            isCorrectValue = true;
        }
        return isCorrectValue;
    }

    private void Sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
