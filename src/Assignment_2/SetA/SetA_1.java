//Program by:Vivek
//Define a “Point” class having members – x,y(coordinates). Define default constructor and
//        parameterized constructors. Define two subclasses “ColorPoint” with member as color and
//        subclass “Point3D” with member as z (coordinate). Write display method to display the
//        details of different types of Points
package Assignment_2.SetA;
class Point{
    protected int x,y;
    public Point(){//Default Constructor
        this.x = 0;
        this.y = 0;
    }

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void display(){
        System.out.println("Point - x: "+x+",y: "+y);
    }
}

class ColorPoint extends Point{
    public String color;
    public ColorPoint(int x,int y,String color){
        super(x,y);
        this.color = color;
    }

    public void display(){
        super.display();
        System.out.println("Color: "+color);
    }
}

class Point3D extends Point{
    private int z;

    public Point3D(int x,int y,int z){
        super(x,y);
        this.z = z;

    }

    public void display(){
        super.display();
        System.out.println("z: "+z);
    }

}
public class SetA_1 {
    public static void main(String[] args) {
        Point point  = new Point(2,3);
        ColorPoint colorPoint = new ColorPoint(5,6,"Red");
        Point3D point3D = new Point3D(8,9,10);

        System.out.println("Point Details");
        point.display();

        System.out.println("Color Point Details:");
        colorPoint.display();

        System.out.println("Point3D Details:");
        point3D.display();
    }
}
