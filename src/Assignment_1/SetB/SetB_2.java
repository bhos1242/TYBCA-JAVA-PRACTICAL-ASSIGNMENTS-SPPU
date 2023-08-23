//Program by:vivek
package Assignment_1.SetB;

import java.util.Scanner;

class Employee {
    String name;
    double salary;

    // Method to set employee information
    void setInfo(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee information
    void getInfo(int i) {
        System.out.println("Details of employee:" + (i + 1));
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class SetB_2 {
    public static void main(String[] args) {
        Employee[] e = new Employee[5];
        Scanner sc = new Scanner(System.in);

        // Taking input and setting information for each employee
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details of Employee:" + (i + 1));
            System.out.println("Enter name:");
            String name = sc.next();
            System.out.println("Enter Salary:");
            double salary = sc.nextDouble();

            e[i] = new Employee();
            e[i].setInfo(name, salary);
        }

        // Displaying information for each employee
        for (int i = 0; i < 5; i++) {
            e[i].getInfo(i);
        }
    }
}

