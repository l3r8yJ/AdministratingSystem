package Interactions;
import Employees.Employee;
import Data.*;
import java.util.Scanner;

public class ConsoleMenu {

    LocalEmployeesList employeesList = new LocalEmployeesList();
    String fileName = "data.csv";
    boolean isRun = true;
    Scanner scanner = new Scanner(System.in);
    int selector;

    public void Run() {
        employeesList.ImportFromFile(fileName);
        while (isRun)
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
                    employeesList.ExportToFile(fileName);
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector);
            }
        }
    }
    private Employee fillForEmployee() {
        String name;
        String phoneNumber;
        Scanner read = new Scanner(System.in);

        System.out.println("Name: ");
        name = read.nextLine();

        System.out.println("Phone number: ");
        phoneNumber = read.next();

        return new Employee(name, phoneNumber);
    }

    private void MenuAdd() {
        var tmp = fillForEmployee();
        employeesList.AddEmployee(new Employee(tmp.getName(), tmp.getPhoneNumber()));
    }

    private void MenuRemove()
    {
        var tmp = fillForEmployee();
        employeesList.DeleteEmployee(tmp.getName(), tmp.getPhoneNumber());
    }
}
