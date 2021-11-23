package Employees;

public class Employee {

    private String name;
    private String phoneNumber;

    public Employee(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setName(String name) {
        if (containsNumber(name))
            throw new NumberFormatException();
        else this.name = name;
    }

    public boolean containsNumber(String string) {
        return string.matches(".*\\d+.*");
    }
}
