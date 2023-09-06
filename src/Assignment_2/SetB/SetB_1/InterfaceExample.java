package Assignment_2.SetB.SetB_1;

interface Operation {
    double area();
    double volume();

    double PI = 3.142; // Constant for PI
}

class Circle implements Operation {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Operation.PI * radius * radius; // Use the constant from the interface
    }

    @Override
    public double volume() {
        return 0; // Circles don't have volume
    }
}

class Cylinder implements Operation {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Operation.PI * radius * radius * height; // Use the constant from the interface
    }

    @Override
    public double area() {
        return (2 * Operation.PI * radius * height) + (2 * Operation.PI * radius * radius);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Cylinder cylinder = new Cylinder(3.0, 7.0);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Volume: " + circle.volume());

        System.out.println("Cylinder Area: " + cylinder.area());
        System.out.println("Cylinder Volume: " + cylinder.volume());
    }
}
