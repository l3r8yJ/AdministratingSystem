package Employees;

public class Freelancer extends Employee {

    String Type = "Freelancer";
    double rate = 1000;
    double salary;

    @Override
    public String GetType() {
        return Type;
    }

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
