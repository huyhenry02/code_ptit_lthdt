import java.util.*;

abstract class Shape{
    private String name;
    public Shape(String name){
        this.name = name;
    }
    
    public abstract double calculateArea();
    
    public void displayInfo(){
        System.out.println("Shape:" + name + "|Area:" + String.format("%.2f",calculateArea()));
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;
    public Rectangle(String name, double width, double length) {
        super(name);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return this.length * this.width;
    }
}


class Circle extends Shape{
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i< testCase; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            String shapeName = parts[0];
            switch (shapeName){
                case "Rectangle": {
                    Rectangle rectangle = new Rectangle("Rectangle", Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                    shapes.add(rectangle);
                    break;
                }
                case "Circle": {
                    Circle circle = new Circle("Circle", Double.parseDouble(parts[1]));
                    shapes.add(circle);
                    break;
                }
            }
        }
        for (Shape s : shapes){
            s.displayInfo();
        }
        sc.close();
    }
}