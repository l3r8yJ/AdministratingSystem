package Employees;

public class Employee {

    private String name;
    private String phoneNumber;
    private String password;
    private int timeOfBeginning;
    private int timeOfShutdown;
    private String type;
    {
        type = "employee";
    }

    public String getType()
    {
        return type;
    }

    int workedTime = 0;

    public Employee() {
    }
    
    public Employee(String name,String phoneNumber, String password, int workedTime, String type) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setWorkedTime(workedTime);
        this.type = type;
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

    public long getTimeOfBeginning() {
        return timeOfBeginning;
    }

    public void setTimeOfBeginning(int timeOfBeginning) {
        this.timeOfBeginning = timeOfBeginning;
    }

    public long getTimeOfShutdown() {
        return timeOfShutdown;
    }

    public void setTimeOfShutdown(int timeOfShutdown) {
        this.timeOfShutdown = timeOfShutdown;
    }

    public int getWorkedTime() {
        return workedTime;
    }

    public void setWorkedTime(int workedTime) {
        this.workedTime = workedTime;
    }

    public void addWorkedTime() {
        workedTime += timeOfShutdown - timeOfBeginning;
    }

    public double getSalary(){
        return 0;
    }
}
