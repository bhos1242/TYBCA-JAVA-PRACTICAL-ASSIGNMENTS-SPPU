package Assignment_2.SetB.SetB_3;

import java.util.Scanner;

abstract class Staff{
    String name;
    String address;

    public Staff(String name,String address){
        this.name = name;
        this.address = address;
    }

    public abstract double calculateSalary();

}

class FullTimeStaff extends Staff{
    String department;
    double salary;
    public FullTimeStaff(String name,String address,String department,double salary){
        super(name,address);
        this.department = department;
        this.salary = salary;
    }

    public double calculateSalary(){
        double hra = 0.08 * salary;
        double da = 0.05*salary;
        return salary+hra+da;
    }
}

class PartTimeStaff extends Staff{
    double numberOfHours;
    double ratePerHour;

    public PartTimeStaff(String name, String address, double numberOfHours, double ratePerHour) {
        super(name, address);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    public double calculateSalary() {
        return numberOfHours * ratePerHour;
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of staff members:");
        int n = scanner.nextInt();

        // Create an array to store staff objects
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter choice for staff member " + (i + 1) + " (F for FullTime / P for PartTime): ");
            String choice = scanner.nextLine().toUpperCase();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            if (choice.equals("F")) {
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                System.out.print("Enter salary: ");
                double salary = scanner.nextDouble();
                staffList[i] = new FullTimeStaff(name, address, department, salary);
            } else if (choice.equals("P")) {
                System.out.print("Enter number of hours: ");
                double numberOfHours = scanner.nextDouble();
                System.out.print("Enter rate per hour: ");
                double ratePerHour = scanner.nextDouble();
                staffList[i] = new PartTimeStaff(name, address, numberOfHours, ratePerHour);
            } else {
                System.out.println("Invalid choice, skipping this staff member.");
                continue;
            }
        }

        System.out.println("\nFull Time Staff:");
        for (Staff staff : staffList) {
            if (staff instanceof FullTimeStaff) {
                System.out.println(staff.name + ": $" + staff.calculateSalary());
            }
        }

        System.out.println("\nPart Time Staff:");
        for (Staff staff : staffList) {
            if (staff instanceof PartTimeStaff) {
                System.out.println(staff.name + ": $" + staff.calculateSalary());
            }
        }
    }

}
