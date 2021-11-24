package Employees;

public class Freelancer extends Employee {

    String Type = "Freelancer";
    double rate = 1000;
    double salary;

    @Override
    public String getType() {
        return Type;
    }

    public Freelancer(String name, String phoneNumber, String password, int workedTime) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setWorkedTime(workedTime);
    }

    @Override
    public double getSalary() {
        salary = rate * workedTime;
        return salary;
    }
}
