package Assignment_1.SetA;

public class SetA_2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage:Java ReverseNumber <number>");
            return;
        }

        // Read the number from the command line argument
        int number = Integer.parseInt(args[0]);

        int reversed = 0;

        // Reverse the number
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;

        }
        System.out.println("Reversed Number: " + reversed);
    }
}
