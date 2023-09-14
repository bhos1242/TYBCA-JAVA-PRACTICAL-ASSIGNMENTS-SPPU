package Assignment_3.SetA;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SetA_2 {
    public static void main(String[] args) {
        //create a Hashmap to store employee names and salary
        Map<String,Double> employeeSalaries = new HashMap<>();

        //Adding some employees and their salaries to the hashmap
        employeeSalaries.put("Vivek",600000.0);
        employeeSalaries.put("Yuvraj",50.0);
        employeeSalaries.put("Raj",400.0);
        employeeSalaries.put("Akash",5000.0);

        //Display the details of the hash table
        for(Map.Entry<String,Double> entry:employeeSalaries.entrySet()){
            String employeeName = entry.getKey();
            double salary = entry.getValue();
            System.out.println("Employee: "+employeeName+", Salary:$"+salary);
        }

        //Search for a specific employee and display their salary
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the employee to search:");
        String searchName = scanner.nextLine();

        if(employeeSalaries.containsKey(searchName)){
            double searchedSalary = employeeSalaries.get(searchName);
            System.out.println("Salary of "+searchName+": $"+searchedSalary);
        }
        else{
            System.out.println("Employee not found");
        }
    }
}
