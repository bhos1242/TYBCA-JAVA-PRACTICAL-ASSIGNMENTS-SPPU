package Assignment_2.SetB.SetB_2;

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: $" + salary);
    }

}

class Developer extends Employee{
    private String projectName;

    public Developer(String name, double salary, String projectName) {
        super(name, salary);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
    public void displayDetails() {
        super.displayDetails(); // Call the parent class method
        System.out.println("Project Name: " + projectName);
    }
}

class Programmer extends Developer{
    private String programmingLanguage;

    public Programmer(String name, double salary, String projectName, String programmingLanguage) {
        super(name, salary, projectName);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void displayDetails() {
        super.displayDetails(); // Call the parent class method
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

public class MultiLeveInheritance {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Vivek",80000.0,"Web Application","Java");
                programmer.displayDetails();
    }
}
