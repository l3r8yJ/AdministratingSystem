package Employees;

import java.util.Date;

public class Freelancer extends Employee {

    double rate = 1000;
    double salary;

    double getSalary() {
        salary = rate * workedTime;
        return salary;
    }
}
