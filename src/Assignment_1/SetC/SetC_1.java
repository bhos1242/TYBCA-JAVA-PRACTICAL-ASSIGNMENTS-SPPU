package Assignment_1.SetC;
class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void display() {
        System.out.println(day + "/" + month + "/" + year);
    }
}
class Person{
    private int id;
    private String name;
    private MyDate dob;
    private static int cnt =1;

    //Default constructor
    public Person(){
        this.id = cnt++;
        this.name = "";
        this.dob = new MyDate(1,1,2000); //Default Date

    }

    //Parameterized constructor
    public Person(String name,MyDate dob){
        this.id = cnt++;
        this.name = name;
        this.dob = dob;
    }

    void accept(String name, MyDate dob){
        this.name = name;
        this.dob = dob;
    }

    public void display(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Date of Birth: ");
        dob.display();
    }


}


public class SetC_1 {

    public static void main(String[] args) {
    Person[] people = new Person[2];

    MyDate dob1 = new MyDate(15,8,1995);
    MyDate dob2 = new MyDate(10,4,1988);

    people[0] = new Person("Vivek", dob1);
    people[1] = new Person();
    people[1].accept("Yuvraj",dob2);

    for(Person person:people){
        person.display();
        System.out.println();
    }
    }
}
