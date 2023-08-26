package Assignment_2.SetA.SetA_3;

import java.util.Scanner;

class Employee {
    static int idCounter = 0;
    protected int id;
    protected String name;
    protected double salary;

    public Employee() {
        id = ++idCounter;
        name = "";
        salary = 0;
    }

    public void accept(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Details of Employee with id: " + id);
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private double bonus;

    public void accept(String name, double salary, double bonus) {
        super.accept(name, salary);
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
        System.out.println("Total salary:"+getTotalSalary());
    }

    double getTotalSalary() {
        return salary + bonus;
    }
}

public class EmployeeClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of managers: ");
        int n = sc.nextInt();

        Manager[] managers = new Manager[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Manager " + (i + 1) + ":");
            managers[i] = new Manager();
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            System.out.print("Enter bonus: ");
            double bonus = sc.nextDouble();
            managers[i].accept(name, salary, bonus);
        }

        int maxIndex = 0;
        double maxTotalSalary = managers[0].getTotalSalary();

        for (int i = 1; i < n; i++) {
            double totalSalary = managers[i].getTotalSalary();
            if (totalSalary > maxTotalSalary) {
                maxTotalSalary = totalSalary;
                maxIndex = i;
            }
        }

        System.out.println("\nDetails of Manager with maximum total salary:");
        managers[maxIndex].display();

        sc.close();
    }
}
