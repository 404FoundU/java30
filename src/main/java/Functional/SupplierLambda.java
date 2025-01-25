package Functional;


import Functional.data.Student;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierLambda {

    static Supplier<Student> studentSupplier = () -> new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"));

    public static void main(String[] args) {
        SupplierLambda test = new SupplierLambda();
        test.testMethod();
    }

    private void testMethod() {
        System.out.println(studentSupplier.get());
    }


}
