package com.company.Employees;

public class EmployeeOnSalary extends Employee {
    double salary = 120000.0;
    String type;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getSalary(){
        if (workedTime > 160) {
            salary *= 2;
        }
        return salary;
    }

    public EmployeeOnSalary(String name, String phoneNumber, String password, int workedTime, String type) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setWorkedTime(workedTime);
        this.type = type;
    }
}
