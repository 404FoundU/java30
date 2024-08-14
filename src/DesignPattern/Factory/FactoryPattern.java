package DesignPattern.Factory;

import DesignPattern.Factory.Factories.OperatingSystem;

public class FactoryPattern {
    public static void main(String[] args) {

        OperatingSystem linux = OperatingSystemFactory.getInstance("LINUX", "DEB", "x64");
        OperatingSystem windows = OperatingSystemFactory.getInstance("WINDOWS", "WIN7", "x64");
        linux.changeDir("C");

    }
}
