package Assignment_1.SetA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetA_1 {
    public static void main(String[] args) throws IOException {
        // Prompt the user to enter a number
        System.out.println("Enter a number");

        // Create a BufferedReader to read user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the input number as a string and convert it to an integer
        int num = Integer.parseInt(br.readLine());

        // Display the heading for the multiplication table
        System.out.println("Multiplication table of given number " + num + " : ");

        // Loop to calculate and print the multiplication table
        for (int i = 1; i <= 10; i++) {
            // Calculate the product of the input number and the loop variable "i"
            int product = num * i;

            // Print the current multiplication step
            System.out.println(num + " * " + i + " = " + product);
        }
    }
}
