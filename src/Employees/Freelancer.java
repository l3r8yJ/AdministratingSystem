package Employees;

import java.util.Date;

public class Freelancer extends Employee {
    double sumTime = 0;
    double rate = 1000;
    double salary = sumTime * rate;
    void setSumTime() {
        sumTime = timeOfShutdown.getTime() - timeOfBeginning.getTime();
    }
}
