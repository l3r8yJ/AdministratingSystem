package Employees;

public class Freelancer extends Employee {

    double rate = 1000;
    double salary;

    double getSalary() {
        salary = rate * workedTime;
        return salary;
    }
}
