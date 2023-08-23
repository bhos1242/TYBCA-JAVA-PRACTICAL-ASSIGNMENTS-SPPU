//Program by Vivek Bhos
//Wrtie a java program to create class as MyDate with dd,mm,yy as data members. Write default and parameterized constructor.
//Display the date in dd-mm-yy format(Use this keyword)

package Assignment_1.SetA;

class MyDate{
    int dd,mm,yy;

    public MyDate(){
        System.out.println("Executing default constructor");
        this.dd = 1;
        this.mm = 1;
        this.yy = 2000;
    }

    public MyDate(int dd,int mm,int yy){
        System.out.println("Executing parameterized constructor");
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public void DispDate(){
        System.out.println("Date is: "+dd+"-"+mm+"-"+yy);

        //using string format
        String formattedDate = String.format("%02d-%02d-%02d",dd,mm,yy);
        System.out.println("FormattedDate is: "+ formattedDate);
    }

}
public class SetA_4 {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(22,12,23);
        d1.DispDate();
    }
}
