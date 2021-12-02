package com.company.Data;

import com.company.Employees.Employee;
import com.company.Employees.EmployeeOnSalary;
import com.company.Employees.Freelancer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class LocalEmployeesList {

    private final ArrayList<Employee> employeeList = new ArrayList<>();

    public LocalEmployeesList() {
    }

    public LocalEmployeesList(String fileName) {
        ImportFromFile(fileName);
    }

    public void AddEmployee(Employee employee) {
        for (var e : employeeList) {
            if (e.getPhoneNumber().equals(employee.getPhoneNumber())) {
                System.out.println("Number already exist!");
                return;
            }
        }
        if (!employee.getName().isEmpty() && !employee.getPhoneNumber().isEmpty() && !employee.getPassword().isEmpty())
            employeeList.add(employee);
        else System.out.println("Empty employee");
    }

    public boolean DeleteEmployee(String number) {
        boolean isContainAnEmployee = false;

        for (var e : employeeList) {
            if (e.getPhoneNumber().equals(number)) {
                isContainAnEmployee = true;
                employeeList.remove(e);
                break;
            }
        }
        return isContainAnEmployee;
    }

    public void ConsolePrint() {
        if (employeeList.isEmpty()) {
            System.out.println("Empty list...");
            return;
        }
        for (var e : employeeList) System.out.println(e.getName() + " " + e.getPhoneNumber() + " " + e.getWorkedTime());
    }

    public void ExportToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (var employee : employeeList) {
                writer.write(employee.getName() + ',' + employee.getPhoneNumber() + ',' + employee.getPassword() + ',' + employee.getWorkedTime() + ',' + employee.getType() + '\n');
                writer.flush();
            }
            System.out.println("Database successfully saved!");
        } catch (IOException ex) {
            System.out.println("Saving error!");
            System.out.println(ex.getMessage());
        }
    }

    public void ImportFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            //checking the types
            while (line != null) {
                String[] fields = line.split(",");
                if (fields[4].equals("Employee on salary")) {
                    employeeList.add(new EmployeeOnSalary(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]));
                } else if (fields[4].equals("Freelancer")) {
                    employeeList.add(new Freelancer(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]));
                }
                line = bufferedReader.readLine();
            }
            System.out.println("Data has been successfully updated!");
        } catch (IOException ex) {
            System.out.println("Import Error!");
            System.out.println(ex.getMessage());
        }
    }

    public void createReport(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Report created at " + Calendar.getInstance().getTime() + '\n');
            for (var employee : employeeList) {
                if (employee.getWorkedTime() > 1)
                    writer.write(employee.getType() + ' ' + employee.getName() + " worked for " + employee.getWorkedTime() + " hours and earned " + employee.getSalary() + " roubles" + '\n');
                else
                    writer.write(employee.getType() + ' ' + employee.getName() + " worked " + employee.getWorkedTime() + " hour and earned " + employee.getSalary() + " roubles" + '\n');
                writer.flush();
            }
            System.out.println("Report successfully created!");
        } catch (IOException ex) {
            System.out.println("Creating error!");
            System.out.println(ex.getMessage());
        }
    }

    public Employee getEmployee(String password, String phoneNumber) {
        Employee employee = null;
        for (var e : employeeList) {
            if (e.getPassword().equals(password) && e.getPhoneNumber().equals(phoneNumber)) {
                    employee = e;
                    break;
            }
        }
        return employee;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void Clear() {
        employeeList.clear();
    }
}
