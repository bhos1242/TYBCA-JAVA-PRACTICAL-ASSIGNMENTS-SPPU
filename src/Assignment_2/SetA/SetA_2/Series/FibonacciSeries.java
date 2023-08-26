package Assignment_2.SetA.SetA_2.Series;

public class FibonacciSeries {
    public static void generateSeries(int n){
        int prev = 0, curr = 1;
        System.out.println("Fibonacci Series:");
        for(int i=0;i<n;i++){
            System.out.println(prev+" ");
            int next = prev+curr;
            prev = curr;
            curr = next;
        }
        System.out.println();
    }
}
