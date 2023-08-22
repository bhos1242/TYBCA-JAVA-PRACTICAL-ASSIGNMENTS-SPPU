//Program by:Vivek Bhos
//Define a class MyNumber having one private integer data member.
//Write a default constructor initialize it to 0 and another constructor to initialize it to a value.
//write methods isNegative,isPositive,isOdd,isEven.
//Use command line argument to pass a value to the object and perform the above tests

package Assignment_1;

class MyNumber{
    private int number;

    public MyNumber(){
        System.out.println("Executing Default constructor:");
        this.number =0;
    }

    public MyNumber(int number){
        this.number = number;
    }

    //check is negative
    public boolean isNegative(){
        return number<0;
    }

    //check is positive
    public boolean isPositive(){
        return  number>0;
    }

    //check number is odd
    public boolean isOdd(){
        return number%2!=0;
    }

    //check is even or not
    public boolean isEven(){
        return number%2==0;
    }


}

public class SetB_1 {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Please provide command line argument");
            return;
        }

        try{
            int value = Integer.parseInt(args[0]); //parse the command line argument
            MyNumber num = new MyNumber(value);

            System.out.println("Number is:"+value);
            System.out.println("isNegative:"+num.isNegative());
            System.out.println("isPositive:"+num.isPositive());
            System.out.println("isOdd"+num.isOdd());
            System.out.println("isEven"+num.isEven());
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input! Please Provide valid integer value");
        }
    }
}
