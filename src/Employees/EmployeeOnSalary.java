package Employees;

import java.util.Date;

public class EmployeeOnSalary extends Employee {
    double salary = 120000.0;
    double sumTime = timeOfShutdown.getTime() - timeOfBeginning.getTime();

    void setSalary() {
        if (sumTime > 160) {
            salary *= 2;
        }
    }

    public EmployeeOnSalary(String name, String phoneNumber, String password) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }
}
