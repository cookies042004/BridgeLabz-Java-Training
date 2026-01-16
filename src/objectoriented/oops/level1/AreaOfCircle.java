package objectoriented.oops.level1;

class Circle{
    double radius;

    // method for calculating raidus
    void calculateRadius(){
        double area = 3.14 * radius * radius;
        System.out.println("Area of circle is : " + area);
    }
}

public class AreaOfCircle {
    public static void main(String[] args) {
        // creating object from the class circle
        Circle c = new Circle();
        // assigning radius
        c.radius = 2.4;

        // calling calculateRadius method
        c.calculateRadius();
    }
}
