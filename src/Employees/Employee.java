package Employees;

import java.sql.Date;

public class Employee {

    private String name;
    private String sex;
    private byte age; //Надо ли это?
    private String phoneNumber;
    private String password;
    private Date getIn;
    private Date getOut;
    private double rate;
    private double salary;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

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

    public Date getGetIn() {
        return getIn;
    }

    public void setGetIn(Date getIn) {
        this.getIn = getIn;
    }

    public Date getGetOut() {
        return getOut;
    }

    public void setGetOut(Date getOut) {
        this.getOut = getOut;
    }
}
