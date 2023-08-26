
package Assignment_2.SetA.SetA_2;

import Assignment_2.SetA.SetA_2.Series.CubeSeries;
import Assignment_2.SetA.SetA_2.Series.FibonacciSeries;
import Assignment_2.SetA.SetA_2.Series.SquareSeries;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        FibonacciSeries.generateSeries(n);
        SquareSeries.generateSeries(n);
        CubeSeries.generateSeries(n);
    }
}
