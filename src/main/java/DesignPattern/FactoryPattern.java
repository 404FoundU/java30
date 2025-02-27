package DesignPattern;

interface Vehicle {
    void drive();
}

class Suv implements Vehicle {

    @Override
    public void drive() {
        System.out.println("suv");
    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("bike");
    }
}

class FactoryProducer {
    public Vehicle getType(String type) {
        if (type.equals("Suv")) {
            return new Suv();
        }
        if (type.equals("Bike")) {
            return new Bike();
        }
        return null;

    }
}

// Create objects of one type
//  FactoryProducer return a concrete class
//JDBCTemplate, KafkaTemplate
public class FactoryPattern {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        Vehicle car = factoryProducer.getType("car");
        car.drive();
        Vehicle bike = factoryProducer.getType("bike");
        bike.drive();
    }
}
