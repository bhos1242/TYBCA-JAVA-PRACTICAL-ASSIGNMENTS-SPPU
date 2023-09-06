package Assignment_2.SetA.SetA_4;

import Assignment_2.SetA.SetA_4.utility.CapitalString;

public class Person {
    private String name;
    private String city;

    public Person(String name,String city){
        this.name = name;
        this.city = city;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCity(){return city;};

    public void setCity(String city){
        this.city = city;
    }
    public static void main(String[] args){
        //creating a Person object
        Person person = new Person("vivek","Pune");

        String capitalizedName = CapitalString.capitalizeFirstLetter(person.getName());

        //Display the person's name with he first letter capital
        System.out.println("Name:"+capitalizedName);
        System.out.println("City:"+person.getCity());
    }
}


