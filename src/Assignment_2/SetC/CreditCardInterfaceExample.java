package Assignment_2.SetC;

interface CreditCardInterface {
    void viewCreditAmount();
    void useCard(double amount);
    void payCredit(double amount);
    void increaseLimit(double amount);
}

// SilverCardCustomer.java
class SilverCardCustomer implements CreditCardInterface {
    private String name;
    private String cardNumber;
    private double creditAmount;
    public double creditLimit;

    public SilverCardCustomer(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.creditAmount = 0;
        this.creditLimit = 50000;
    }

    @Override
    public void viewCreditAmount() {
        System.out.println("Silver Card Customer: " + name);
        System.out.println("Credit Amount: " + creditAmount);
        System.out.println("Credit Limit: " + creditLimit);
    }

    @Override
    public void useCard(double amount) {
        if (creditAmount + amount <= creditLimit) {
            creditAmount += amount;
            System.out.println("Transaction Successful: Used " + amount + " Rs.");
        } else {
            System.out.println("Transaction Failed: Credit Limit Exceeded.");
        }
    }

    @Override
    public void payCredit(double amount) {
        if (amount <= creditAmount) {
            creditAmount -= amount;
            System.out.println("Transaction Successful: Paid " + amount + " Rs.");
        } else {
            System.out.println("Transaction Failed: Insufficient Credit Amount.");
        }
    }

    @Override
    public void increaseLimit(double amount) {
        System.out.println("Transaction Failed: Only Gold Card Customers can increase the limit.");
    }
}

// GoldCardCustomer.java
class GoldCardCustomer extends SilverCardCustomer {
    private int limitIncreaseCount;

    public GoldCardCustomer(String name, String cardNumber) {
        super(name, cardNumber);
        this.creditLimit = 100000;
        this.limitIncreaseCount = 0;
    }

    @Override
    public void increaseLimit(double amount) {
        if (limitIncreaseCount < 3 && creditLimit + amount <= 100000) {
            creditLimit += amount;
            limitIncreaseCount++;
            System.out.println("Transaction Successful: Increased Credit Limit by " + amount + " Rs.");
        } else {
            System.out.println("Transaction Failed: Limit Increase Limit Exceeded or Maximum Increase Reached.");
        }
    }
}

public class CreditCardInterfaceExample {
    public static void main(String[] args) {
        SilverCardCustomer silverCustomer = new SilverCardCustomer("Vivek", "1234567890123456");
        GoldCardCustomer goldCustomer = new GoldCardCustomer("Yuvraj", "9876543210987654");

        silverCustomer.viewCreditAmount();
        silverCustomer.useCard(30000);
        silverCustomer.payCredit(10000);
        silverCustomer.viewCreditAmount();
        silverCustomer.increaseLimit(5000);

        goldCustomer.viewCreditAmount();
        goldCustomer.useCard(80000);
        goldCustomer.payCredit(30000);
        goldCustomer.increaseLimit(6000);
        goldCustomer.increaseLimit(6000);
        goldCustomer.increaseLimit(6000);
        goldCustomer.increaseLimit(6000);

        silverCustomer.viewCreditAmount();
        goldCustomer.viewCreditAmount();
    }
}
