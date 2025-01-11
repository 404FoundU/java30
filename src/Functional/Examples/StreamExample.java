package Functional.Examples;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(101, "siva", 101, "active", 2000));
        empList.add(new Employee(102, "reddy", 101, "active", 5000));
        empList.add(new Employee(103, "raju", 102, "inactive", 6000));
        empList.add(new Employee(104, "shivam", 102, "inactive", 4000));
        empList.add(new Employee(105, "bob", 103, "active", 3500));
        empList.add(new Employee(106, "alice", 103, "inactive", 3500));
        empList.add(new Employee(107, "srinu", 104, "active", 3500));
        //print emp details based on dept

        Map<Integer, List<Employee>> depMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.toList()));

     /*   depMap.forEach((k,v)->{
            System.out.println("k = " + k);
            v.forEach(System.out::println);
                }
        );


        depMap.entrySet()
                .forEach(entry -> {
                    System.out.println("Department ID: " + entry.getKey());
                    entry.getValue().forEach(System.out::println);
                });*/

        // print employee count in each dept
        Map<Integer, Long> deptCount = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.counting()));
/*        deptCount.forEach((k,v)->{
                    System.out.println("k = " + k);
            System.out.println("v = " + v);
                }
        )*/
        ;

        // active and inactive employees in the collection
        Map<String, List<Employee>> activeMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getStatus(), Collectors.toList()));
        activeMap.entrySet()
                .forEach(
                        (entry) -> {
                            System.out.println("entry.getKey() = " + entry.getKey());
                            entry.getValue().forEach(System.out::println);
                        }
                );

        // count of active and inactive
        long activeCount = empList.stream()
                .filter(e -> "active".equals(e.getStatus()))
                .count();

        // max min employee salary

        Optional<Employee> maxSalary = empList.stream()
                .max((a, b) -> Integer.compare(a.getSalary(), b.getSalary()));

        maxSalary.ifPresent(s -> System.out.println("salary = " + s));

        empList.stream()
                .max(Comparator.comparing(e -> e.getSalary()))
                .ifPresent(s -> System.out.println("salary = " + s));
        //max salary of an employee for each dept

        Map<Integer, Optional<Employee>> salaryMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(),
                        Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));

        salaryMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            v.ifPresent(e -> System.out.println("salary = " + e.getSalary()));
        });


    }


}

// Assuming the Employee class looks something like this:
class Employee {
    private int empId;
    private String name;
    private int deptId;
    private String status;
    private int salary;

    public Employee(int empId, String name, int deptId, String status, int salary) {
        this.empId = empId;
        this.name = name;
        this.deptId = deptId;
        this.status = status;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    // Getters and setters can be added here for access
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", deptId=" + deptId + ", status=" + status + ", salary=" + salary + "]";
    }
}
