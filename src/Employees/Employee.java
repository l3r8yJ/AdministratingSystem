package Employees;
import java.util.Date;

public class Employee {

    private String name;
    private String phoneNumber;
    private String password;
    protected Date timeOfBeginning;
    protected Date timeOfShutdown;

    public Employee() {
    }
    
    public Employee(String name, String phoneNumber, String password) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        if (password.length() < 5) System.out.println("Password must be at least 5 characters!");
        else this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected void setName(String name) {
        if (containsNumber(name))
            throw new NumberFormatException();
        else this.name = name;
    }

    public boolean containsNumber(String string) {
        return string.matches(".*\\d+.*");
    }

    public Date getTimeOfBeginning() {
        return timeOfBeginning;
    }

    public void setTimeOfBeginning(Date timeOfBeginning) {
        this.timeOfBeginning = timeOfBeginning;
    }

    public Date getTimeOfShutdown() {
        return timeOfShutdown;
    }

    public void setTimeOfShutdown(Date getOut) {
        this.timeOfShutdown = getOut;
    }
}
