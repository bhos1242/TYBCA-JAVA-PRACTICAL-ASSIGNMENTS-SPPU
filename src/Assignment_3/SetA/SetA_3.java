package Assignment_3.SetA;

import java.util.Scanner;

class ZeroNumberException extends Exception {
    public ZeroNumberException(String message) {
        super(message);
    }
}

public class SetA_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number:");
            int number = scanner.nextInt();

            if (number == 0) {
                throw new ZeroNumberException("Number is 0");
            } else if (isPrime(number)) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        } catch (ZeroNumberException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true; // Add this line to indicate that the number is prime
    }
}
