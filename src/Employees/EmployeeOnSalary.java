package Employees;


public class EmployeeOnSalary extends Employee {
    double salary = 120000.0;
    static String type = "Employee on salary.";

    @Override
    public String getType() {
        return type;
    }

    void setSalary() {
        if (workedTime > 160) {
            salary *= 2;
        }
    }

    public EmployeeOnSalary(String name, String phoneNumber, String password, int workedTime) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setWorkedTime(workedTime);
    }
}
