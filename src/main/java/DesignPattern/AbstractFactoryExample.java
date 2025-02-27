package DesignPattern;

// Product Interfaces
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Products
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

// Abstract Factory
interface UIComponentFactory {
    Button createButton();

    Checkbox createCheckbox();
}

// Concrete Factories
class WindowsFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// The Abstract Factory Pattern is used to create families of related or dependent objects,
// ensuring that objects from the same family are used together.
//Produces multiple related products like button, checkbox
public class AbstractFactoryExample {
    public static void main(String[] args) {
        WindowsFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render(); // Output: Rendering Windows Button
        checkbox.render(); // Output: Rendering Windows Checkbox
    }
}




