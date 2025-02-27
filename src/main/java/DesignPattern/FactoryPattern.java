package DesignPattern;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("car");
    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("bike");
    }
}

class VehicleFactory {
    public Vehicle getType(String type) {
        if (type.equals("Car")) {
            return new Car();
        }
        if (type.equals("Bike")) {
            return new Bike();
        }
        return null;

    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle car = vehicleFactory.getType("car");
        car.drive();
        Vehicle bike = vehicleFactory.getType("bike");
        bike.drive();
    }
}
