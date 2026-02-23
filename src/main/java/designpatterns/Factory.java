package designpatterns;

interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Circle");
    }
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println("Rectangle");
    }
}

class ShapeFactory{
    public static Shape getShape(String type){
        if(type.equalsIgnoreCase("circle")){
            return new Circle();
        }
        else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();
    }
}
