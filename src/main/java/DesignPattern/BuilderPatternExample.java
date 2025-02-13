package DesignPattern;

// Product class with private constructor
class Car {
    private String engine;
    private int wheels;
    private boolean airConditioning;

    // Private Constructor


    public Car(String engine, int wheels, boolean airConditioning) {
        this.engine = engine;
        this.wheels = wheels;
        this.airConditioning = airConditioning;
    }

    // Display the Car details
    public void display() {
        System.out.println("Car with Engine: " + engine + ", Wheels: " + wheels + ", AC: " + airConditioning);
    }

    // Static Inner Builder Class
    public static class CarBuilder {
        private String engine;
        private int wheels;
        private boolean airConditioning;

        public CarBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public CarBuilder setAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public Car build() {
            return new Car(engine, wheels, airConditioning);
        }
    }
}

// Testing the Builder Pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Creating an object using the Builder Pattern
        Car car = new Car.CarBuilder("V8", 4)
                .setAirConditioning(true)
                .build();
        car.display();
    }
}

