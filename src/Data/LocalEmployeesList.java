package Data;

import Employees.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LocalEmployeesList {

    private final ArrayList<Employee> employeeList = new ArrayList<>();

    public void AddEmployee(Employee employee) {
        for (var e : employeeList) {
            if (e.getPhoneNumber().equals(employee.getPhoneNumber())) {
                System.out.println("Number already exist!");
                return;
            }
        }
        if (!employee.getName().isEmpty() && !employee.getPhoneNumber().isEmpty() && !employee.getPassword().isEmpty()) employeeList.add(employee);
        else System.out.println("Empty employee");
    }

    public void DeleteEmployee(String number) {
        employeeList.removeIf(e -> e.getPhoneNumber().equals(number));
    }

    public void ConsolePrint() {
        if (employeeList.isEmpty())
        {
            System.out.println("Empty list...");
            return;
        }
        for (var e : employeeList) System.out.println(e.getName() + " " + e.getPhoneNumber() + " " + e.getWorkedTime());
    }
    public void ExportToFile(String fileName) {
       try(FileWriter writer = new FileWriter(fileName, false)) {
           for (var employee : employeeList) {
               writer.write(employee.getName() + ',' + employee.getType() + ',' + employee.getPhoneNumber() + ',' + employee.getPassword() + ',' + employee.getWorkedTime() +'\n');
               writer.flush();
           }
           System.out.println("Database successfully saved!");
       } catch (IOException ex) {
           System.out.println("Saving error!");
           System.out.println(ex.getMessage());
       }
    }
    public void ImportFromFile(String fileName) {
        try(FileReader reader = new FileReader(fileName))
        {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employeeList.add(new Employee(fields[0], fields[2], fields[3], Integer.parseInt(fields[4])));
                line = bufferedReader.readLine();
            }
            System.out.println("Data has been successfully updated!");
        }
        catch(IOException ex){
            System.out.println("Import Error!");
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void Clear() {
        employeeList.clear();
    }
}
