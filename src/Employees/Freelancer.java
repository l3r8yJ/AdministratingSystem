package Employees;

public class Freelancer extends Employee {

    String Type = "Freelancer";
    double rate = 1000;
    double salary;

    @Override
    public String getType() {
        return Type;
    }

    public Freelancer(String name, String phoneNumber, String password, int workedTime, String type) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setWorkedTime(workedTime);
        this.Type = type;
    }

    @Override
    public double getSalary() {
        salary = rate * workedTime;
        return salary;
    }
}
