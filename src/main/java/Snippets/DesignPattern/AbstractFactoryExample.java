package Snippets.DesignPattern;

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
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class UIFactoryProducer {
    public static UIFactory getType(String type) {
        if (type.equals("Windows")) {
            return new WindowsFactory();
        }
        if (type.equals("Mac")) {
            return new MacFactory();
        }
        return null;
    }
}

//  used to create families of related  objects,
// Factory of Factories ( UIFactoryProducer returns another WindowsFactory or MacFactory)
// BeanFactory, ApplicationContext
public class AbstractFactoryExample {
    public static void main(String[] args) {
        UIFactory windowsFactory = UIFactoryProducer.getType("Windows");
        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsButton.render();
        windowsCheckbox.render();
    }
}




