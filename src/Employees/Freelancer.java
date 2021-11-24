package Employees;

public class Freelancer extends Employee {

    String type = "Freelancer";
    double rate = 1000;
    double salary = rate * workedTime;

    @Override
    public String getType() {
        return type;
    }

    public Freelancer(String name, String phoneNumber, String password, int workedTime) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    double getSalary() {
        return salary;
    }
}
