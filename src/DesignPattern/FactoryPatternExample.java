package DesignPattern;

// Shape interface
interface Shape {
    void draw();
}

// Concrete implementations
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Abstract Factory
interface ShapeFactory {
    Shape createShape();
}

// Concrete Factories
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

//The Factory Method Pattern allows subclasses to decide which class to instantiate.
// Produces a single product shape
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory();
        Shape shape = factory.createShape();
        shape.draw(); // Output: Drawing a Circle
    }
}
