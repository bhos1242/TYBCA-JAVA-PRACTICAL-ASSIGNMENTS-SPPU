package Assignment_3.SetA;

import java.util.*;

public class SetA_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Integers:");
        int n = scanner.nextInt();

        //Create a TreeSet to store unique integers in sorted order
        Set<Integer> uniqueSortedSet = new TreeSet<>();

        for(int i=0;i<n;i++){
            System.out.println("Enter integer #"+(i+1));
            int num = scanner.nextInt();
            uniqueSortedSet.add(num);
        }

        //Display the integers in sorted order
        System.out.println("Integers in sorted order");
        for(int num:uniqueSortedSet){
            System.out.println(num);
        }

        //Search for a particular element
        System.out.println("Enter the element to search for:");
        int searchElement = scanner.nextInt();

        if(uniqueSortedSet.contains(searchElement)){
            System.out.println(searchElement + " is in the collection");
        }
        else{
            System.out.println(searchElement + " is not in the collection");
        }

        scanner.close();
    }
}
