//Program by Vivek
//Write a java program to create class Account (accno, accname, balance). Create an array
        //of “n” Account objects. Define static method “sortAccount” which sorts the array on the
        //basis of balance. Display account details in sorted order.

package Assignment_1.SetB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Account{
    int accno;
    String accname;
    double balance;

    Account(int accno,String accname,double balance){
        this.accno = accno;
        this.accname = accname;
        this.balance = balance;
    }

    //Method to display accound details
    void displayAccoundDetails(){
        System.out.println("Account Number:"+accno);
        System.out.println("Account Name:"+accname);
        System.out.println("Balance:"+balance);
        System.out.println();
    }

    //static method to sort accounts based on balance
    static void sortAccount(Account[] accounts){
        Arrays.sort(accounts, Comparator.comparingDouble(account -> account.balance));
    }
}
public class SetB_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of accounts:");
        int n = sc.nextInt();

        Account[] accounts = new Account[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter details for Account "+ (i+1));
            System.out.println("Account Number:");
            int accno = sc.nextInt();
            System.out.println("Account Name:");
            String accname = sc.next();
            System.out.println("Account Balance:");
            double balance = sc.nextDouble();
            accounts[i] = new Account(accno,accname,balance);
        }

        //sort accounts based on balance
        Account.sortAccount(accounts);

        System.out.println("Account details after sorting:");
        for(Account account:accounts){
            account.displayAccoundDetails();

        }
    }
}


//    Static methods in Java belong to the class itself and are not associated with instances of the class. They are used for operations that are related to the class as a whole and don't rely on instance-specific data. In the provided code, the static method sortAccount is used to sort an array of Account objects based on their balance.