package Assignment_3.SetB;

import java.util.Scanner;

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class SetB_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the doctor's name: ");
        String doctorName = scanner.nextLine();

        try {
            validateDoctorName(doctorName);
            System.out.println("Doctor's name is valid: " + doctorName);
        } catch (InvalidNameException e) {
            System.err.println("Invalid doctor's name: " + e.getMessage());
        }
    }

    public static void validateDoctorName(String name) throws InvalidNameException {
        if (name.matches(".*[0-9!@#$%^&*()_+{}|:\"<>?~].*")) {
            throw new InvalidNameException("Name is Invalid");
        }
    }
}
