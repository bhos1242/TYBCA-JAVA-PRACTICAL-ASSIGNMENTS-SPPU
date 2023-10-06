package Assignment_3.SetB;
//3. Write a java program to accept details of n customers (c_id, cname, address, mobile_no)
//        from user and store it in a file (Use DataOutputStream class). Display the details of
//        customers by reading it from file.(Use DataInputStream class)

import java.io.*;

class Customer{
    int c_id;
    String cname;
    String address;
    String mobile_no;

    public Customer(int c_id,String cname,String address,String mobile_no){
        this.c_id = c_id;
        this.cname = cname;
        this.address = address;
        this.mobile_no = mobile_no;
    }
}
public class SetB_3 {

    public static void main(String[] args) throws IOException {
        try {
            // Accept number of customers from user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the number of customers: ");
            int n = Integer.parseInt(reader.readLine());

            // Accept and store customer details in a file using DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("customer_details.dat"));
            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for customer " + (i + 1) + ":");
                System.out.print("Customer ID: ");
                int c_id = Integer.parseInt(reader.readLine());
                System.out.print("Customer Name: ");
                String cname = reader.readLine();
                System.out.print("Address: ");
                String address = reader.readLine();
                System.out.print("Mobile Number: ");
                String mobile_no = reader.readLine();

                // Write customer details to the file
                dataOutputStream.writeInt(c_id);
                dataOutputStream.writeUTF(cname);
                dataOutputStream.writeUTF(address);
                dataOutputStream.writeUTF(mobile_no);
            }
            dataOutputStream.close();

            // Read and display customer details from the file using DataInputStream
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("customer_details.dat"));
            System.out.println("\nCustomer Details:");
            for (int i = 0; i < n; i++) {
                int c_id = dataInputStream.readInt();
                String cname = dataInputStream.readUTF();
                String address = dataInputStream.readUTF();
                String mobile_no = dataInputStream.readUTF();
                System.out.println("Customer ID: " + c_id);
                System.out.println("Customer Name: " + cname);
                System.out.println("Address: " + address);
                System.out.println("Mobile Number: " + mobile_no);
                System.out.println("-------------------------");
            }
            dataInputStream.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

//Certainly! Imagine you have a computer program, and you want to save some data from your program to a file so that you can use it later, even after you close the program. Java provides a way to do this through classes like DataOutputStream.
//
//        DataOutputStream is a class in Java that allows you to write primitive data types (like integers, doubles, and strings) to an output stream, which could be a file. It's like having a special pen that can only write specific types of information on paper.
//
//        Here's a breakdown of why DataOutputStream is useful:
//
//        Simplicity: It simplifies the process of writing data to a file. You don't have to worry about converting your data into a format that the file can understand. DataOutputStream does this conversion for you.
//
//        Type Safety: It ensures that the data you write is of a specific type. For example, if you want to write an integer, you use writeInt(). This way, when you read the data back, you know exactly what type of data to expect.
//
//        Compatibility: The data written by DataOutputStream can be easily read by a DataInputStream later. So, if you write data to a file using DataOutputStream, you can confidently read it back with DataInputStream and be sure of the data types.
//
//        Here's a simple analogy:
//
//        Think of your data as different kinds of fruits (integers are apples, strings are oranges, etc.). DataOutputStream is like a specialized fruit basket that only accepts specific types of fruits. When you put an apple (integer) in the basket, it knows it's an apple. Later, when you want to use the apple, you take it out of the basket and you know it's still an apple. DataOutputStream and DataInputStream are like these specialized baskets, ensuring that your data stays organized and understandable, even when you store it in a file and retrieve it later.
//
//        In summary, DataOutputStream helps you neatly store different types of data in a file, making it easy to save and retrieve your program's information.
