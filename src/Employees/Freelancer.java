package Employees;

import java.util.Date;

public class Freelancer extends Employee {

    static String Type = "Freelancer";
    double rate = 1000;
    double salary;

    public Freelancer(String name, String phoneNumber, String password) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    double getSalary() {
        salary = rate * workedTime;
        return salary;
    }
}
