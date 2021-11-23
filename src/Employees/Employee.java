package Employees;

public class Employee {

    private String name;
    private String phoneNumber;
    private String password;

    public Employee(String name, String phoneNumber, String password) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (password.length() < 5) System.out.println("Password must be at least 5 characters!");
        else this.password = password;
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
